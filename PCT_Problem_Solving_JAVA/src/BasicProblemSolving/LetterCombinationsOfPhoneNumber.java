package BasicProblemSolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LetterCombinationsOfPhoneNumber {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String strInput = sc.nextLine();

		System.out.print(getLetterCombination(String.valueOf(strInput)));
		sc.close();
	}

	private static ArrayList<String> getLetterCombination(String strInput) {
		ArrayList<String> stringCombination = new ArrayList<String>();
		if (strInput.isEmpty() || !strInput.matches(".*\\d.*"))
			return stringCombination;

		HashMap<String, String> key = new HashMap<String, String>();
		key.put("2", "abc");
		key.put("3", "def");
		key.put("4", "ghi");
		key.put("5", "jkl");
		key.put("6", "mno");
		key.put("7", "pqrs");
		key.put("8", "tuv");
		key.put("9", "wxyz");

		String[][] arrayInp = new String[strInput.length()][4];
		int[] charNumPerLine = new int[strInput.length()];

		for (int i = 0; i < strInput.length(); i++) {
			String getKey = strInput.charAt(i) + "";
			arrayInp[i] = key.get(getKey).split("");
			charNumPerLine[i] = arrayInp[i].length; // num of column
		}

		findDPCombination(arrayInp, charNumPerLine, stringCombination);

		return stringCombination;
	}

	private static void findDPCombination(String[][] blocks2D, int[] charNum,
			ArrayList<String> stringCombination) {
		int numCombinations = 1;
		int inpNum = blocks2D.length;
		for (int i = 0; i < inpNum; i++) {
			numCombinations *= charNum[i];
		}

		int[] indices = new int[inpNum];
		for (int i = 0; i < numCombinations; i++) {
			// Store combination blocks in an ArrayList
			String addChar = "";
			for (int j = 0; j < inpNum; j++) {
				addChar += blocks2D[j][indices[j]];
				
			}
			stringCombination.add(addChar);
			// Try all different choices of blocks.
			// *** Important: Must remember this piece of code to change row and column
			// value to get for combination.
			for (int j = 0; j < inpNum; j++) {
				if (indices[j] < charNum[j] - 1) {
					indices[j]++;
					break;
				} else
					indices[j] = 0;
			}
		}
	}
}


