package PathWithMinimumCost;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPathSum_64 {
	// Problem Statement: https://leetcode.com/problems/minimum-path-sum/
	/*
	 * Driver program to test above functions
	 * 
	 * You can only traverse DOWN & RIGHT and Not DIAGONALLY lower cells from a
	 * given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) can be
	 * traversed
	 * 
	 */
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int col = scan.nextInt();
		
		int cost[][] = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				cost[i][j] = scan.nextInt();
			}
			scan.nextLine();
		}
		System.out.println(minCost(cost));

		scan.close();

	}

	/* A utility function that returns minimum of 3 integers */
	private static int min(int x, int y) {
		int[] findMin = { x, y };
		return Arrays.stream(findMin).min().getAsInt();
	}

	private static int minCost(int cost[][]) {
		int row, col;
		int rowLen = cost.length;
		int colLen = cost[0].length;
		int tc[][] = new int[rowLen][colLen];
		// total cost (tc) table from S->D using original cost table.

		tc[0][0] = cost[0][0];

		/* Initialize summation of FIRST ROW (i = 0) of all column of total cost(tc) 2D array */
		for (col = 1; col < colLen; col++)
			tc[0][col] = tc[0][col - 1] + cost[0][col];

		/* Initialize summation of FIRST COLUMN (j = 0) of all row of total cost(tc) 2D array */
		for (row = 1; row < rowLen; row++)
			tc[row][0] = tc[row - 1][0] + cost[row][0];

		/* Construct rest of the tc array */
		for (row = 1; row < rowLen; row++)
			for (col = 1; col < colLen; col++)
				tc[row][col] = cost[row][col] + min(tc[row - 1][col], tc[row][col - 1]);

		return tc[rowLen - 1][colLen - 1];
	}
}

// [[1,2,5],[3,2,1]]
