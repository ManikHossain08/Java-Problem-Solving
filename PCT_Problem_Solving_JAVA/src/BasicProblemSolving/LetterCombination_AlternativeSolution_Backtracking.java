package BasicProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombination_AlternativeSolution_Backtracking {
	// private static final String[] chars = { "", "", "abc", "def", "ghi", "jkl",
	// "mno", "pqrs", "tuv", "wxyz" };
	private static final String[][] KEYS = { null, null, { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" },
			{ "j", "k", "l" }, { "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };
	private static String digits;

	public static void main(String args[]) {
		// https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8403/*Java*-very-straightforward-iterative-solution-(1ms)
		Scanner sc = new Scanner(System.in);
		digits = sc.nextLine();

		System.out.print(getLetterCombination(String.valueOf(digits)));
		sc.close();
	}

	private static List<String> getLetterCombination(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0)
			return result;
		backtracking(result, new StringBuilder(), 0);
		return result;
	}

	public static void backtracking(List<String> result, StringBuilder sb, int index) {
		if (index == digits.length()) {
			result.add(sb.toString());
			return;
		}
		// Note: THIS COMMENTED CODE IS ASSOCIATED WITH COMMNETED ARRAY IN THE TOP LINE
		
		// String str = chars[digits.charAt(index) - '0'];
		// for (char c : str.toCharArray()) {
		
		String[] strList = KEYS[digits.charAt(index) - '0'];
		for (String s : strList) {
			sb.append(s);
			backtracking(result, sb, index + 1);
			sb.setLength(sb.length() - s.length());
		}
	}
}