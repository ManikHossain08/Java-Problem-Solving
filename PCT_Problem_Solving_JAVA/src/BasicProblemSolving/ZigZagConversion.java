package BasicProblemSolving;

import java.util.Scanner;

public class ZigZagConversion {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int rowNumber = sc.nextInt();
		System.out.print(findZigZagConversion(input, rowNumber));
		sc.close();
	}

	private static String findZigZagConversion(String input, int numRows) {
		int column = 0, row = 0, rowNumber = numRows;
		String output = "";
		String[][] arrProcess = new String[rowNumber][input.length() + 1];

		for (int i = 1; i <= input.length(); i++) {

			arrProcess[row][column] = input.charAt(i - 1) + "";

			if (row + 1 == rowNumber) {

				for (int j = 1; j <= rowNumber - 2 && i + 1 <= input.length(); j++) {
					i++;
					row--;
					column++;
					arrProcess[row][column] = input.charAt(i - 1) + "";
				}
				row = -1;
				column++;
			}
			row++;
		}

		for (int i = 0; i < rowNumber; i++) {
			for (int j = 0; j < input.length() + 1; j++) {
				if (arrProcess[i][j] != null)
					output = output + arrProcess[i][j];
			}
		}

		return output;
	}

}
