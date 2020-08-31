package RegularExpressionMatching;

import java.util.Scanner;

public class MySolution_regularExpression_LC10 {
	
	// concept: https://www.youtube.com/watch?v=l3hda49XcDE
	// but there is some concept mismatch
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String r = sc.nextLine();

		System.out.print(isREmatchede(s, r));

		sc.close();
	}

	private static boolean isREmatchede(String s, String p) {
		int strlen = s.length();
		int patlen = p.length();
		boolean[][] dp = new boolean[strlen + 1][patlen + 1];
		dp[0][0] = true;
		// only initialize the pattern true if '*' found in the string 
		for (int i = 1; i <= patlen; i++) {
			if (p.charAt(i - 1) == '*')
				dp[0][i] = dp[0][i - 2];
			else
				dp[0][i] = false;
		}

		for (int row = 1; row <= s.length(); row++) {
			for (int col = 1; col <= p.length(); col++) {
				if (p.charAt(col - 1) == '*') {
					dp[row][col] = dp[row][col - 2];
					if (p.charAt(col - 2) == s.charAt(row - 1) || p.charAt(col - 2) == '.')
						dp[row][col] = dp[row][col - 2] || dp[row - 1][col];
				} else if (s.charAt(row - 1) == p.charAt(col - 1) || p.charAt(col - 1) == '.') {
					dp[row][col] = dp[row-1][col-1];
				} else {
					dp[row][col] = false;
				}
			}
		}
		return dp[strlen][patlen];
	}
}
