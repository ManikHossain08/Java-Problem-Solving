package EditDinstanceFindMinOperation;

import java.util.Scanner;

public class EditDistanceAlternative_72 {
	public static void main(String args[]) {
		// Note: this program has small similarity with the 'find Interleaving string
		// between the string.
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		// this is also called dynamic programming
		System.out.print(findMinEditDistance(str1, str2));

		sc.close();
	}

	private static int findMinEditDistance(String word1, String word2) {
		if (word1.equals(word2)) {
			return 0;
		}
		if (word1.length() == 0 || word2.length() == 0) {
			return Math.abs(word1.length() - word2.length());
		}
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= word2.length(); i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
}
