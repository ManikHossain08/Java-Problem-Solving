package Two_2D_ArrayOPerations;

import java.util.Arrays;
import java.util.Scanner;

public class LC73_Set_Matrix_Zeroes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();

		int[][] matrix = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		matrix = setZerosMatrix(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] +" ");
			}
			System.out.println();
		}

		sc.close();
	}

	private static int[][] setZerosMatrix(int[][] matrix) {
		int[][] temp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				temp[i][j] = matrix[i][j];
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					setZeroMatrix(temp, i, j);
				}
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				matrix[i][j] = temp[i][j];
			}
		}
		
		return temp;
	}

	private static void setZeroMatrix(int[][] temp, int i, int j) {
		int[] row = new int[temp.length];
		row = temp[i];
		Arrays.fill(row, 0);
		temp[i] = row;
		for (int k = 0; k < temp.length; k++) {
			temp[k][j] = 0;
		}

	}
}

/*
 * 
3
4
1 1 1 2
1 0 1 4
1 1 1 5
 * 
 */
