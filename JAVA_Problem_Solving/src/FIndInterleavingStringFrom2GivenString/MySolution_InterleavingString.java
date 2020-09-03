package FIndInterleavingStringFrom2GivenString;

import java.util.Scanner;

public class MySolution_InterleavingString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		String s3 = sc.nextLine();

		System.out.print(isInterleaving(s1, s2, s3));

		sc.close();
	}

	private static boolean isInterleaving(String s1, String s2, String s3) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];
		dp[0][0] = true;

		// Initializing row;
		for (int i = 0; i < s1Len; i++) {
			if (s1.charAt(i) == s3.charAt(i))
				dp[i + 1][0] = true;
			else
				break;
		}

		// Initializing column;
		for (int i = 0; i < s2Len; i++) {
			if (s2.charAt(i) == s3.charAt(i))
				dp[0][i + 1] = true;
			else
				break;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				char targetChar = s3.charAt(i + j - 1);
				if (s1.charAt(i - 1) == targetChar) {
					if (dp[i - 1][j])
						dp[i][j] = true;

				} else if (s2.charAt(j - 1) == targetChar) {
					if (dp[i][j - 1])
						dp[i][j] = true;
				}
			}
		}

		return dp[s1Len][s2Len];
	}
}
