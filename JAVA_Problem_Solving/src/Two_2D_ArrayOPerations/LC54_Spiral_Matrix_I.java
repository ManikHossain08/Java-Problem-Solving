package Two_2D_ArrayOPerations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC54_Spiral_Matrix_I {

	private static int[][] dice = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private static int direction = 0;
	private static List<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// int size = sc.nextInt();

		// int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr = { { 1,2,3,4 }, { 5, 6,7,8 }, { 9,10,11,12 } };
		result = spiralOrder(arr);

		System.out.print(result);

		sc.close();

	}

	private static List<Integer> spiralOrder(int[][] matrix) {
		if(matrix.length == 0 && matrix[0].length == 0) return result;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int[] initPos = { 0, 0 };
		result.add(matrix[0][0]);
		visited[0][0] = true;
		for (int i = 1; i < matrix.length * matrix[0].length; i++) {
			initPos = findNextPlace(initPos, matrix, visited);
		}

		return result;
	}

	private static int[] findNextPlace(int[] initPos, int[][] matrix, boolean[][] visited) {

		int[] nextDir = dice[direction];
		int x = initPos[0] + nextDir[0];
		int y = initPos[1] + nextDir[1];

		if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || visited[x][y] == true) {
			direction = (direction + 1) % 4;
			nextDir = dice[direction];
			x = initPos[0] + nextDir[0];
			y = initPos[1] + nextDir[1];
		}
		if (visited[x][y] == false) {
			result.add(matrix[x][y]);
			visited[x][y] = true;
		}
		initPos[0] = x;
		initPos[1] = y;

		return initPos;
	}
}

/*
 [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
