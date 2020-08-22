package BasicProblemSolving;

import java.util.Scanner;

public class MySolution_RotateImage_LC48 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int lines = sc.nextInt();
		sc.nextLine();
		String[][] inputs = new String[lines][];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = sc.nextLine().split(",");
		}

		int[][] arrInp = new int[inputs.length][inputs[0].length];
		for (int i = 0; i < inputs.length; i++) {
			for (int j = 0; j < arrInp[0].length; j++) {
				arrInp[i][j] = Integer.parseInt(inputs[i][j]);
			}
		}
		arrInp = rotateImage(arrInp);
		System.out.print(arrInp);
		sc.close();
	}

	private static int[][] rotateImage(int[][] arrInp) {
		int[][] tempArrInp = new int[arrInp.length][arrInp[0].length];
		for (int i = 0; i < arrInp.length; i++) {
			int[] rows = arrInp[i];
			nowRotateIt(tempArrInp, rows, arrInp[0].length - i - 1);
		}
		arrInp = tempArrInp;
		return arrInp;
	}

	private static void nowRotateIt(int[][] tempArrInp, int[] rows, int col) {
		for (int i = 0; i < rows.length; i++) {
			tempArrInp[i][col] = rows[i];
		}
	}
}
