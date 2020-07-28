package ValidSudoku;

import java.util.Arrays;
import java.util.Scanner;

public class ValidSudoku {

	private static int[] validityArr = new int[10];
	private static int maxAtRow = 0;
//	private static int[] x = { 1, 1, 0, -1, -1, -1, 0, 1 };
//	private static int[] y = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String[][] arrInp = new String[9][9];

		for (int i = 0; i < arrInp.length; i++) {
			arrInp[i] = sc.nextLine().split(" ");
		}

		System.out.print(findValidSudookuInWholematrix(arrInp));
		sc.close();
	}

	private static boolean findValidSudookuInWholematrix(String[][] arrInp) {
		boolean isvalid = true;
		// checking each row at once
		for (int row = 0; row < arrInp.length; row++) {
			for (int column = 0; column < arrInp[row].length; column++) {
				String value = arrInp[row][column];
				if (!value.equals("."))
					validityArr[value.charAt(0) - '0']++;
			}

			maxAtRow = getMaxValue(validityArr);
			if (maxAtRow > 1) {
				isvalid = false;
				break;
			} else {
				validityArr = new int[10];
			}
		}

		// checking each row at once
		for (int column = 0; column < arrInp.length; column++) {
			for (int row = 0; row < arrInp[column].length; row++) {
				String value = arrInp[row][column];
				if (!value.equals("."))
					validityArr[value.charAt(0) - '0']++;

			}
			int maxAtRow = getMaxValue(validityArr);
			if (maxAtRow > 1) {
				isvalid = false;
				break;
			} else {
				validityArr = new int[10];
			}
		}

		if(isvalid) {
			isvalid = findValidSudookuInWholeSubMatrix(arrInp); 
		}

		return isvalid;
	}

	private static boolean findValidSudookuInWholeSubMatrix(String[][] arrInp) {
		boolean isvalid = true;
		for (int i = 0; i < arrInp.length; i = i + 3) {
			for (int j = 0; j < arrInp.length; j = j + 3) {
				int positionX = i, positionY = j;
				int[][] tempTable = new int[3][3];
				isvalid = findSudokuinSubtable(positionX, positionY, tempTable, arrInp);
				if(!isvalid) break;
			}
			if(!isvalid) break;
		}
	return isvalid;	
	}

	private static boolean findSudokuinSubtable(int positionX, int positionY, int[][] tempTable, String[][] arrInp) {
		boolean isvalid = true;
		for (int i = positionX, l = 0; i < positionX + 3; i++, l++) {
			for (int j = positionY, m = 0; j < positionY + 3; j++, m++) {
				String value = arrInp[i][j];
				if (!value.equals("."))
					validityArr[value.charAt(0) - '0']++;
			}
		}
		
		int maxAtRow = getMaxValue(validityArr);
		if (maxAtRow > 1) {
			isvalid = false;
		} else {
			validityArr = new int[10];
		}
		
		
//		for (int i = 0; i < tempTable.length; i++) {
//			for (int j = 0; j < tempTable[0].length; j++) {
//				String value = arrInp[i][j];
//				if (!value.equals("."))
//					validityArr[value.charAt(0) - '0']++;
//			}
//		}
		
		
		return isvalid;
	}

	private static int getMaxValue(int[] validityArr) {
		return Arrays.stream(validityArr).max().getAsInt();
	}
}

/*
 * 

5 3 . . 7 . . . .
6 . . 1 9 5 . . .
. 9 8 . . . . 6 .
8 . . . 6 . . . 3
4 . . 8 . 3 . . 1
7 . . . 2 . . . 6
. 6 . . . . 2 8 .
. . . 4 1 9 . . 5
. . . . 8 . . 7 9

 * 
 */
