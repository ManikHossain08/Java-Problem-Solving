package BasicProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySolution_LetterCombinationOfPhoneNumber {

	public static String[] letters = { null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	public static List<String> result = new ArrayList<String>();
	
//	private static final String[][] KEYS = { null, null, { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" },
//			{ "j", "k", "l" }, { "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String digits = sc.nextLine();

		System.out.print(letterCombinations(digits));
		sc.close();
	}

	public static List<String> letterCombinations(String digits) {
		
		if(digits.isEmpty() || digits.contentEquals("")) 
			return new ArrayList<String>();
		return findCombinations(digits, "", 0);
	}
	
	public static List<String> findCombinations(String digits, String Combination, int indeex) {

		if (indeex == digits.length()) {
			 result.add(Combination);
			 return null;
		}
		String getLetter = letters[Integer.parseInt(digits.charAt(indeex) + "")];
		for (int j = 0; j < getLetter.length(); j++) {
			findCombinations(digits, Combination + getLetter.charAt(j) + "", indeex + 1);
		}

		return result;
	}
}
