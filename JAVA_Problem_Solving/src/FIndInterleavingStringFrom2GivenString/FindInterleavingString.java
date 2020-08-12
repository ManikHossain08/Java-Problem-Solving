package FIndInterleavingStringFrom2GivenString;

import java.util.Scanner;

public class FindInterleavingString {
	public static void main(String args[]) {
		FindInterleavingString obj = new FindInterleavingString();
		Scanner scan = new Scanner(System.in);
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		String str3 = scan.nextLine();

		System.out.print(obj.isInterleave(str1, str2, str3) == true ? "Yes" : "No");
		scan.close();
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		int rowLen = s1.length() + 1, columnLen = s2.length() + 1;

		// no need to initialize this 2D array because its declare its automatically
		// initialized by zero. So the bellow code was for initialization.
		boolean memo[][] = new boolean[rowLen][columnLen];
		// if the length doesn't match
		if (s3.length() != s1.length() + s2.length())
			return false;

		// Initializing the matrix memo
		memo[0][0] = true;
		for (int row = 1; row < rowLen; row++) {
			if (s3.charAt(row - 1) == s1.charAt(row - 1))
				memo[row][0] = true;
			else
				break;
		}
		for (int col = 1; col < columnLen; col++) {
			if (s3.charAt(col - 1) == s2.charAt(col - 1))
				memo[0][col] = true;
			else
				break;
		}

		// Iteratively checking when a character matches and filling up the table
		for (int row = 1; row < rowLen; row++) {
			for (int col = 1; col < columnLen; col++) {
				char targetS3Char = s3.charAt(row + col - 1);
				if (targetS3Char == s1.charAt(row - 1)) {
					if (memo[row - 1][col] == true)
						memo[row][col] = memo[row - 1][col]; // i.e, previous row true 
				}
				if (targetS3Char == s2.charAt(col - 1)) {
					if (memo[row][col - 1] == true)
						memo[row][col] = memo[row][col - 1]; // i.e, previous column true 
				}
			}
		}

		return memo[s1.length()][s2.length()];

	}
}
