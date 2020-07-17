package EditDinstanceFindMinOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EditDistance {
	public static void main(String args[]) {
		// Note: this program has small similarity with the 'find Interleaving string 
		// between the string.
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

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

		int rows = word1.length() + 1, columns = word2.length() + 1;
		int[][] dp = new int[rows][rows];
		
		// Note: FIRST ROW AND FIRST COLUMN IS THE INITIALIZATION IN THIS GRID
		// TO MAKE CALCULAITON. 
		for (int i = 0; i < rows; i++) {
			dp[i][0] = i;
		}

		for (int i = 0; i < columns; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {

				int x = dp[i][j - 1] + 1; // previous COLUMN from current position.
				int y = dp[i - 1][j] + 1; // previous ROW from current position.
				int z;
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					z = dp[i - 1][j - 1] + 0;
				}
				else {
					z = dp[i - 1][j - 1] + 1;
				}

				dp[i][j] = getMinValue(x, y, z);

			}
		}
		return dp[word1.length()][word2.length()];
	}

	private static int getMinValue(int x, int y, int z) {
		List<Integer> findMin = new ArrayList<>();
		findMin.add(x);
		findMin.add(y);
		findMin.add(z);
		return Collections.min(findMin);
	}
}
