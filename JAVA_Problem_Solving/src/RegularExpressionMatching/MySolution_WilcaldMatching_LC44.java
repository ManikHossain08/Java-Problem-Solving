package RegularExpressionMatching;

import java.util.Scanner;

public class MySolution_WilcaldMatching_LC44 {
	// concept: https://www.youtube.com/watch?v=3ZDZ-N0EPV0

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String p = sc.nextLine();

		System.out.print(isWildcardmatchede(s, p));

		sc.close();
	}

	private static boolean isWildcardmatchede(String s, String p) {
		int strlen = s.length();
		int patlen = p.length();
		boolean[][] dp = new boolean[strlen + 1][patlen + 1];
		dp[0][0] = true;
		// only initialize the pattern true if '*' found in the string
		for (int i = 1; i <= patlen; i++) {
			if (p.charAt(i - 1) == '*')
				dp[0][i] = dp[0][i - 1];
			else
				dp[0][i] = false;
		}

		for (int row = 1; row <= s.length(); row++) {
			for (int col = 1; col <= p.length(); col++) {
				if (p.charAt(col - 1) == '*') {
					dp[row][col] = dp[row][col - 1] || dp[row - 1][col]; 
				} else if (p.charAt(col - 1) == '?' || p.charAt(col - 1) == s.charAt(row - 1)) {
					dp[row][col] = dp[row - 1][col - 1];
				} else {
					dp[row][col] = false;
				}
			}
		}
		return dp[strlen][patlen];
	}
}
