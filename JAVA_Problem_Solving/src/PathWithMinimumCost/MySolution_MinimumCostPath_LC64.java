package PathWithMinimumCost;

import java.util.Scanner;

public class MySolution_MinimumCostPath_LC64 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lineno = sc.nextInt();
		sc.nextLine();
		String[][] inputs = new String[lineno][lineno];
		for (int i = 0; i < lineno; i++) {
			inputs[i] = sc.nextLine().split(",");
		}

		int[][] costsum = new int[lineno][lineno];
		for (int i = 0; i < costsum.length; i++) {
			for (int j = 0; j < costsum.length; j++) {
				costsum[i][j] = Integer.parseInt(inputs[i][j]);
			}
		}

		System.out.print(minPathSum(costsum));

		sc.close();
	}

	public static int minPathSum(int[][] grid) {
		// initial sum for all rows
		for (int row = 1; row < grid.length; row++) {
			grid[row][0] = grid[row - 1][0] + grid[row][0];
		}

		for (int col = 1; col < grid[0].length; col++) {
			grid[0][col] = grid[0][col - 1] + grid[0][col];
		}

		for (int row = 1; row < grid.length; row++) {
			for (int col = 1; col < grid[0].length; col++) {
				grid[row][col] = Math.min(grid[row - 1][col], grid[row][col - 1]) + grid[row][col];
			}
		}

		return grid[grid.length-1][grid[0].length-1];
	}
}
