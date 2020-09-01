package PathWithMinimumCost;

import java.util.Scanner;

public class Diffificult_Leave_UniquePathsThree_LC980 {
	
	public static int rows, cols;
	public static int[][] grid;
	public static int path_count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		rows = m;
		cols = n;
		grid = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		uniquePathsThree(rows, cols, 0);
		System.out.println(path_count);

		sc.close();
	}

	private static void uniquePathsThree(int row, int col, int remain) {
		// base case for the termination of backtracking
        if (grid[row][col] == 2 && remain == 1) {
            // reach the destination
            path_count += 1;
            return;
        }

        // mark the square as visited. case: 0, 1, 2
        int temp = grid[row][col];
        grid[row][col] = -4;
        remain -= 1; // we now have one less square to visit

        // explore the 4 potential directions around
        int[] row_offsets = {0, 0, 1, -1};
        int[] col_offsets = {1, -1, 0, 0};
        for (int i = 0; i < 4; ++i) {
            int next_row = row + row_offsets[i];
            int next_col = col + col_offsets[i];

            if (0 > next_row || next_row >= rows ||
                0 > next_col || next_col >= cols)
                // invalid coordinate
                continue;

            if (grid[next_row][next_col] < 0)
                // either obstacle or visited square
                continue;

            uniquePathsThree(next_row, next_col, remain);
        }

        // unmark the square after the visit
        grid[row][col] = temp;
    }

    public int uniquePathsIII(int[][] grid) {
        int non_obstacles = 0, start_row = 0, start_col = 0;

        rows = grid.length;
        cols = grid[0].length;

        // step 1). initialize the conditions for backtracking
        //   i.e. initial state and final state
        for (int row = 0; row < rows; ++row)
            for (int col = 0; col < cols; ++col) {
                int cell = grid[row][col];
                if (cell >= 0)
                    non_obstacles += 1;
                if (cell == 1) {
                    start_row = row;
                    start_col = col;
                }
            }

        path_count = 0;
        Diffificult_Leave_UniquePathsThree_LC980.grid = grid;

        // kick-off the backtracking
        uniquePathsThree(start_row, start_col, non_obstacles);

        return path_count;
    }
}
