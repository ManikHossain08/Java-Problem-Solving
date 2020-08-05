package BasicProblemSolving;

import java.util.Scanner;

public class RotateImage {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int numLines = sc.nextInt();
		sc.nextLine(); // This removes the extra \n after first integer input.

		String[][] blocks2D = new String[numLines][];
		for (int i = 0; i < numLines; i++) {
			// Generating 2D array from here like [[a,b,c], [d,e,f]]
			blocks2D[i] = sc.nextLine().split(",");
		}

		int[][] outPut = new int[blocks2D.length][blocks2D[0].length];

		for (int i = 0; i < blocks2D.length; i++) {
			for (int j = 0; j < blocks2D[0].length; j++) {
				outPut[i][j] = Integer.parseInt(blocks2D[i][j]);
			}
		}
		int[][] tempTable = rotate(outPut);
		for (int i = 0; i < tempTable.length; i++) {
			for (int j = 0; j < tempTable[0].length; j++) {
				System.out.print(tempTable[i][j]);
			}
		}

		sc.close();
	}


	private static int [][] rotate(int[][] outPut) {
		int[][] tempTable = new int[outPut[0].length][outPut.length];

		for (int column = 0; column < outPut[0].length; column++) {
			for (int row = outPut.length - 1; row >= 0; row--) {
				tempTable[column][(outPut.length - 1) - row] = outPut[row][column];
			}
		}
       return outPut = tempTable;
	}
}
