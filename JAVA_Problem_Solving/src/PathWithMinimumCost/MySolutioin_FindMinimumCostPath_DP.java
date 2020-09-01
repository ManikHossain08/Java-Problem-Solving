package PathWithMinimumCost;

import java.util.Scanner;

public class MySolutioin_FindMinimumCostPath_DP {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lineNo = sc.nextInt();
		sc.nextLine();

		String[][] mincostStr = new String[lineNo][lineNo];
		for (int i = 0; i < lineNo; i++) {
			mincostStr[i] = sc.nextLine().split(" ");
		}
		int[][] mincost = new int[lineNo][lineNo];
		for (int i = 0; i < lineNo; i++) {
			for (int j = 0; j < lineNo; j++) {
				mincost[i][j] = Integer.parseInt(mincostStr[i][j]);
			}
		}

		System.out.print(findMinCostPaths(mincost));
		sc.close();
	}

	private static int findMinCostPaths( int[][] mincost) {
		int startingVal = 0;
		int minCostPath = mincost[0][mincost.length - 1];
		
		for (int i = 1; i < mincost.length; i++) {
			for (int j = 1; j < mincost.length; j++) {

				if (mincost[i][j] == 0) {
					int initvalue = mincost[i][j - 1] == 1000 ? 0 : mincost[i][j - 1];
					mincost[i][j] = initvalue + mincost[i - 1][j];
					startingVal = mincost[i][j];
				} else if (mincost[i][j] == 1000) {
					continue;
				} else {
					mincost[i][j] = mincost[i][j] + startingVal;
				}

				if (j == mincost.length - 1) {
					minCostPath = Math.min(minCostPath, mincost[i][j]);
				}
			}
		}
		return minCostPath;
	}

}
/*
inputs:
5
0 15 80 90 70
1000 0 20 50 90
1000 1000 0 70 10
1000 1000 1000 0 90
1000 1000 1000 1000 0

o/p: 45
 */
