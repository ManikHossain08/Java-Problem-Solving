package PathWithMinimumCost;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumCostPath2_GeekForGeeks {

	// Problem Statement: https://www.geeksforgeeks.org/min-cost-path-dp-6/
	/* Driver program to test above functions 
	 * 
	 You can only traverse DOWN, RIGHT AND DIAGONALLY lower cells from a given
	 cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1)
	 can be traversed
	 * 
	 * */
	
	
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		int numStations = Integer.parseInt(scan.nextLine());

		int cost[][] = new int[numStations][numStations];

		for (int i = 0; i < numStations; i++) {
			for (int j = 0; j < numStations; j++) {
				cost[i][j] = scan.nextInt();
			}
			scan.nextLine();
		}
		System.out.println(minCost(cost, numStations - 1, numStations - 1));

		scan.close();

	}

	/* A utility function that returns minimum of 3 integers */
	private static int min(int x, int y, int z) {
		int[] findMin = { x, y, z };
		return Arrays.stream(findMin).min().getAsInt();
	}

	private static int minCost(int cost[][], int m, int n) {
		int i, j;
		int tc[][] = new int[m + 1][n + 1]; // total cost table from S->D

		tc[0][0] = cost[0][0];

		/* Initialize FIRST ROW (i=0) of tc array */
		for (j = 1; j <= n; j++)
			tc[0][j] = tc[0][j - 1] + cost[0][j];

		/* Initialize FIRST COLUMN (j=0) of total cost(tc) array */
		for (i = 1; i <= m; i++)
			tc[i][0] = tc[i - 1][0] + cost[i][0];

		/* Construct rest of the tc array */
		for (i = 1; i <= m; i++)
			for (j = 1; j <= n; j++)
				tc[i][j] = cost[i][j] + min(tc[i - 1][j - 1], tc[i - 1][j], tc[i][j - 1]);

		return tc[m][n];
	}

}
