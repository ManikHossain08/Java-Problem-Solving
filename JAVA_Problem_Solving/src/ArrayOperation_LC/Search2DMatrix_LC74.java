package ArrayOperation_LC;

import java.util.Scanner;

public class Search2DMatrix_LC74 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[][] arr2d = new int[size][size];
		for (int i = 0; i < arr2d.length; i++) {
			for (int j = 0; j < arr2d[i].length; j++) {
				arr2d[i][j] = sc.nextInt();
			}
		}
		int target = sc.nextInt();
		System.out.print(search2DArray(arr2d, target));
		sc.close();
	}

	private static boolean search2DArray(int[][] arr2d, int target) {
		for (int i = 0; i < arr2d.length; i++) {
			for (int j = 0; j < arr2d[i].length; j++) {
				if (arr2d[i][j] == target)
					return true;
			}
		}

		return false;
	}

}
