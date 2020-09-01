package PathWithMinimumCost;

import java.util.Scanner;

public class MySolution_uniquePathOne_LC62 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		

		System.out.print(uniquePathsOne(m, n));

		sc.close();
	}

	public static int uniquePathsOne(int m, int n) {
		
		int[][] paths = new int[m][n];
		if (paths[0][0] == 1)
			return 0;
		else
			paths[0][0] = 1;

		// initialize all row
		for (int row = 1; row < paths.length; row++) {
			if (paths[row][0] == 0)
				paths[row][0] = 1;
		}
		// initialize all columns
		for (int col = 1; col < paths[0].length; col++) {
			if (paths[0][col] == 0)
				paths[0][col] = 1;
		}

		for (int row = 1; row < paths.length; row++) {
			for (int col = 1; col < paths[0].length; col++) {
				paths[row][col] = paths[row - 1][col] + paths[row][col - 1];
			}
		}

		return paths[paths.length - 1][paths[0].length - 1];
	}
}
