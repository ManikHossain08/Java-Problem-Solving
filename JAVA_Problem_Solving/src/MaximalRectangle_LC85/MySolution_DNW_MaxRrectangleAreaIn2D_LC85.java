package MaximalRectangle_LC85;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MySolution_DNW_MaxRrectangleAreaIn2D_LC85 {

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
		if (matrix.length == 0)
			return 0;
//		if (matrix.length == 1 && matrix[0].length == 1)
//			return Integer.parseInt(matrix[0][0] + "");

		int maxArea = 0;
		int count = 0;
		List<Integer> squareList = new ArrayList<Integer>();

		int[][] grid = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				grid[i][j] = Integer.parseInt(matrix[i][j] + "");
			}
		}

		// initially row calculation
		for (int row = 0; row < grid.length; row++) {
			if (grid[row][0] == 1) {
				count += grid[row][0];
			} else if (grid[row][0] == 0) {
				maxArea = Math.max(maxArea, count);
				count = 0;
			}
		}
		maxArea = Math.max(maxArea, count);
		count = 0;
		// initially column calculation
		for (int col = 0; col < grid[0].length; col++) {
			if (grid[0][col] == 1) {
				count += grid[0][col];
			} else if (grid[0][col] == 0) {
				maxArea = Math.max(maxArea, count);
				count = 0;
			}
		}
		maxArea = Math.max(maxArea, count);
		count = 0;
		
		for (int row = 1; row < grid.length; row++) {
			for (int col = 1; col < grid[0].length; col++) {
				if (grid[row][col] >= 1 && grid[row - 1][col] >= 1 && grid[row][col - 1] >= 1
						&& grid[row - 1][col - 1] >= 1) {
					squareList.add(grid[row][col]);
					squareList.add(grid[row - 1][col]);
					squareList.add(grid[row][col - 1]);
					squareList.add(grid[row - 1][col - 1]);
					int interMax = Collections.max(squareList).intValue();
					if (interMax > 1) {
						grid[row][col] = interMax + 2;
					} else {
						grid[row][col] = 4;
					}
				}

				maxArea = Math.max(maxArea, grid[row][col]);
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
