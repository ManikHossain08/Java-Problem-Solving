package PathWithMinimumCost;

import java.util.Scanner;

public class UniquePathsTwo_63 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		String[][] inp = new String[n][];

		for (int i = 0; i < n; i++) {
			inp[i] = sc.nextLine().split(" ");
		}

		int[][] grid = new int[inp.length][inp[0].length];
		for (int i = 0; i < inp.length; i++) {
			for (int j = 0; j < inp[0].length; j++) {
				grid[i][j] = Integer.parseInt(inp[i][j]);
			}
		}

		System.out.print(findUniquePath(grid));
		sc.close();
	}

	private static int findUniquePath(int[][] inpArray) {
		int rowX = inpArray.length, colY = inpArray[0].length;

		if (inpArray[0][0] == 1)
			return 0;

		inpArray[0][0] = 1;

		for (int row = 1; row < rowX; row++) {
			if (inpArray[row][0] == 0 && inpArray[row - 1][0] == 1)
				inpArray[row][0] = 1;
			else {
				inpArray[row][0] = 0;
				// break; // make all 1 to 0
			}
		}
		for (int col = 1; col < colY; col++) {
			if (inpArray[0][col] == 0 && inpArray[0][col - 1] == 1)
				inpArray[0][col] = 1;
			else {
				inpArray[0][col] = 0;
				// break; // make all 1 to 0
			}
		}

		for (int row = 1; row < rowX; row++) {
			for (int col = 1; col < colY; col++) {
				if (inpArray[row][col] == 0)
					inpArray[row][col] = inpArray[row][col - 1] + inpArray[row - 1][col];
				else
					inpArray[row][col] = 0;
			}
		}

		return inpArray[rowX - 1][colY - 1];
	}
}
