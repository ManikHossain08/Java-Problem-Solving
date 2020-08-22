package BasicProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySolutionBy2D_LetterCombinationOfPhoneNumber2 {

	// public static String[] letters = { null, null, "abc", "def", "ghi", "jkl",
	// "mno", "pqrs", "tuv", "wxyz" };
	public static List<String> result = new ArrayList<String>();

	private static final String[][] letters = { null, null, { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" },
			{ "j", "k", "l" }, { "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String digits = sc.nextLine();

		System.out.print(letterCombinations(digits));
		sc.close();
	}

	public static List<String> letterCombinations(String digits) {

		if (digits.isEmpty() || digits.contentEquals(""))
			return new ArrayList<String>();
		return findCombinations(digits, "", 0);
	}

	public static List<String> findCombinations(String digits, String Combination, int index) {

		if (index == digits.length()) {
			result.add(Combination);
			return null;
		}
		String[] getLetter = letters[digits.charAt(index) - '0'];

		for (int j = 0; j < getLetter.length; j++) {
			findCombinations(digits, Combination + getLetter[j] + "", index + 1);
			/*
			 * if we use StringBuilder or List for storing combination then we have to remove 
			 * the last word from the list for second combination before adding to the final
			 * result list... please see alternative solution of same problem.
			 */
		}

		return result;
	}
}
