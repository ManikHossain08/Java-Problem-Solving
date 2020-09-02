package MaximalSquare_Rectangle;

import java.util.Scanner;

public class LeetCode_DP_Soln_MaxRrectangleAreaIn2D_LC86 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();

		char[][] grid = new char[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				String ch = sc.next();
				grid[i][j] = ch.charAt(0);
			}
		}

		System.out.print(findRectangleArea2Ds(grid));
		sc.close();
	}

	private static int findRectangleArea2Ds(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int maxArea = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dp = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
					int length = dp[i][j];
					for (int k = i; k >= 0; k--) {
						length = Math.min(length, dp[k][j]); // horizontal
						int width = i - k + 1; // vertical
						maxArea = Math.max(maxArea, length * width);
					}
				}
			}
		}
		return maxArea;
	}

}

/*
4 
5 
1 0 1 0 0 
1 0 1 1 1 
1 1 1 1 1 
1 0 0 1 0
 */
