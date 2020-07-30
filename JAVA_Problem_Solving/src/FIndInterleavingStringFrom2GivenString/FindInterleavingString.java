package FIndInterleavingStringFrom2GivenString;

import java.util.Scanner;

public class FindInterleavingString {
	public static void main(String args[]) {
		FindInterleavingString obj = new FindInterleavingString();
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		String str3 = scan.nextLine();

		// no need to initialize this 2D array because its declare its automatically
		// initialized by zero. So the bellow code was for initialization.

		int memo[][] = new int[str1.length() + 1][str2.length() + 1];
//		for (int i = 0; i < str1.length(); i++) {
//			for (int j = 0; j < str2.length(); j++) {
//				memo[i][j] = 0;
//			}
//		}

		System.out.print(obj.isInterleave(str1, str2, str3, memo) == 1 ? "Yes" : "No");
		scan.close();
	}

	public int isInterleave(String s1, String s2, String s3, int memo[][]) {
		// if the length doesn't match
		if (s3.length() != s1.length() + s2.length())
			return 0;

		// Initializing the matrix memo
		memo[0][0] = 1;
		for (int i = 1; i <= s1.length(); i++) {
			if (s3.charAt(i - 1) == s1.charAt(i - 1))
				memo[i][0] = 1;
			else
				break;
		}
		for (int j = 1; j <= s2.length(); j++) {
			if (s3.charAt(j - 1) == s2.charAt(j - 1))
				memo[j][0] = 1;
			else
				break;
		}

		// Iteratively checking when a character matches and filling up the table
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
					if (memo[i - 1][j] == 1)
						memo[i][j] = 1;
				}
				if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
					if (memo[i][j - 1] == 1)
						memo[i][j] = 1;
				}
			}
		}

		return memo[s1.length()][s2.length()];

	}
}
