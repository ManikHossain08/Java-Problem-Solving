package Two_2D_ArrayOPerations;

import java.util.Scanner;

public class LC240_Search_2D_Matrix_II {
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
		int target = sc.nextInt();
		System.out.print(searchMatrix(matrix, target));
		sc.close();

	}

	private static boolean searchMatrix(int[][] matrix, int target) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == target)
					return true;
			}
		}

		return false;
	}
}

/*
5
5
1 4 7 11 15
2 5 8 12 19
3 6 9 16 22
10 13 14 17 24
18 21 23 26 30
*/