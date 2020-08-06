package BasicProblemSolving;

import java.util.Scanner;

public class UniquePaths {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.print(findUniquePath(m, n));
		sc.close();
	}

	private static int findUniquePath(int m, int n) {
		int[][] inpArray = new int[n][m];

		for (int row = 0; row < n; row++) {
			inpArray[row][0] = 1;
		}
		for (int col = 0; col < m; col++) {
			inpArray[0][col] = 1;
		}

		for (int row = 1; row < n; row++) {
			for (int col = 1; col < m; col++) {
				inpArray[row][col] = inpArray[row][col - 1] + inpArray[row - 1][col];
			}
		}

		return inpArray[n-1][m-1];
	}
}
