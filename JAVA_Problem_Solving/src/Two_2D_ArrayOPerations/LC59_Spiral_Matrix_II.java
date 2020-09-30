package Two_2D_ArrayOPerations;

import java.util.Scanner;

public class LC59_Spiral_Matrix_II {

	private static int[][] dice = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private static int direction = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[][] result = new int[size][size];
		result = generateMatrix(size);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

		sc.close();

	}

	private static int[][] generateMatrix(int size) {
		
		
		int[][] matrix = new int[size][size];
		int[] initPos = { 0, 0 };
		matrix[0][0] = 1;
		if(size == 1) return matrix;
		for (int i = 1; i <= size * size; i++) {
			initPos = findNextPlace(initPos, matrix, i + 1);
		}

		return matrix;
	}

	private static int[] findNextPlace(int[] initPos, int[][] matrix, int value) {
		int size = matrix.length;

		int[] nextDir = dice[direction];
		int x = initPos[0] + nextDir[0];
		int y = initPos[1] + nextDir[1];

		if (x < 0 || y < 0 || x >= size || y >= size || matrix[x][y] != 0) {
			direction = (direction + 1) % 4;
			nextDir = dice[direction];
			x = initPos[0] + nextDir[0];
			y = initPos[1] + nextDir[1];
		}
		if (matrix[x][y] == 0) {
			matrix[x][y] = value;
		}

		initPos[0] = x;
		initPos[1] = y;

		return initPos;
	}
}

/*
 * Not worked : need to fix it. 4 Output: 
 * Expected: for 4
 * [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]] (4) 
 * expected: for 5
 * [[1,2,3,4,5],[16,17,18,19,6],[15,24,25,20,7],[14,23,22,21,8],[13,12,11,10,9]]
 * 
 */
