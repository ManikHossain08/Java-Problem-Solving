package Two_2D_ArrayOPerations;

import java.util.Scanner;

public class LC200_Number_Of_Islands {

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, 1, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int row = sc.nextInt();
		int col = sc.nextInt();
		char[][] grid = new char[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				grid[i][j] = sc.next().charAt(0);
			}
		}

		System.out.print(numIslands(grid));
		sc.close();
	}

	private static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int islands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					explore(grid, i, j);
					islands++;
				}
			}
		}
		return islands;
	}

	private static void explore(char[][] grid, int i, int j) {
		grid[i][j] = 'x';
		for (int d = 0; d < dx.length; d++) {
			if (i + dy[d] < grid.length && i + dy[d] >= 0 && j + dx[d] < grid[0].length && j + dx[d] >= 0
					&& grid[i + dy[d]][j + dx[d]] == '1') {
				explore(grid, i + dy[d], j + dx[d]);
			}
		}
	}

}
/*
4
5
1 1 1 1 0
1 1 0 1 0
1 1 0 0 0
0 0 0 0 0
*/

