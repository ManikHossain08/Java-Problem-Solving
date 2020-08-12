package MaximalRectangle_LC85;

import java.util.Scanner;
import java.util.Stack;

public class MaximalRectangle {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int numLines = sc.nextInt();
		sc.nextLine(); // This removes the extra \n after first integer input.

		String[][] blocks2D = new String[numLines][];
		for (int i = 0; i < numLines; i++) {
			// Generating 2D array from here like [[a,b,c], [d,e,f]]
			blocks2D[i] = sc.nextLine().split(",");
		}

		System.out.print(findMaximalRectangle(blocks2D));
		sc.close();
	}

	private static int findMaximalRectangle(String[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		if (row == 0 || col == 0)
			return 0;
		int ret = 0;
		int[][] height = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0)
					height[i][j] = matrix[i][j] == "1" ? 1 : 0;
				else
					height[i][j] = matrix[i][j] == "1" ? height[i - 1][j] + 1 : 0;
			}
		}
		for (int i = 0; i < row; i++) {
			Stack<Integer> stack = new Stack<>();
			for (int j = 0; j <= col; j++) {
				int cur = j == col ? -1 : height[i][j];
				while (!stack.empty() && height[i][stack.peek()] > cur) {
					int h = height[i][stack.pop()];
					int w = stack.empty() ? j : j - stack.peek() - 1;
					ret = Math.max(ret, h * w);
				}
				stack.push(j);
			}
		}
		return ret;
	}
}
