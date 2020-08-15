package BasicProblemSolving;

import java.util.Scanner;

public class FibonacciSeriesDP {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int inp = sc.nextInt();
		int[] memo = new int[inp];
		System.out.print(findFibonacciSeries(inp, memo));
		sc.close();

	}

	private static int findFibonacciSeries(int n, int[] memo) {
		memo[0] = 0;
		memo[1] = 1;
		if (n > 0 && (n == 1 || n == 2))
			return 1;
		else
			for (int i = 2; i < n; i++) {
				memo[i] = memo[i - 1] + memo[i - 2];
			}

		return memo[n - 1];
	}
}
