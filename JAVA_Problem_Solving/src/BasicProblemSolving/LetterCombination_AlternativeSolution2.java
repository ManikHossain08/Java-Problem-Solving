package BasicProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombination_AlternativeSolution2 {
	private static String digits;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		digits = sc.nextLine();

		System.out.print(getLetterCombination(String.valueOf(digits)));
		sc.close();
	}

	private static List<String> getLetterCombination(String digits) {
		List<String> list = new ArrayList<String>();
		if ("".equals(digits))
			return list;

		String[][] map = { null, null, { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
				{ "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };

		list.add("");
		for (int i = 0; i < digits.length(); i++) {
			int digit = digits.charAt(i) - '0';
			List<String> prev = list;
			list = new ArrayList<String>();
			for (String str1 : map[digit]) {
				for (String str2 : prev) {
					list.add(str2 + str1);
				}
			}
		}
		return list;
	}
}