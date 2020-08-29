package ValidLongestParenthesis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MySolution_RemoveInvalidParenthesis_LC301 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputs = sc.nextLine();

		System.out.print(removeInvalidParentheses(inputs));
		sc.close();
	}

	private static List<String> removeInvalidParentheses(String s) {
		Set<String> originalStr = new HashSet<String>();
		List<String> result = new ArrayList<String>();

		originalStr.add(s);
		while (!originalStr.isEmpty()) {

			for (String str : originalStr) {
				if (isValidParenthesis(str))
					result.add(str);
			}

			if (!result.isEmpty())
				return result;

			Set<String> deletedStr = new HashSet<String>();
			for (String str : originalStr) {
				for (int i = 0; i < str.length(); i++) {
					StringBuilder sb = new StringBuilder(str);
					deletedStr.add(sb.deleteCharAt(i).toString());
				}
			}

			originalStr = deletedStr;
		}
		
		if (result.isEmpty()) result.add(""); 
		
		return result;
	}

	private static boolean isValidParenthesis(String inputs) {
		int count = 0;
		for (int i = 0; i < inputs.length(); i++) {
			char ch = inputs.charAt(i);
			if (ch == '(') count++;
			if (ch == ')') count--;
			if (count < 0)
				return false;
		}

		return inputs.length() != 0 && count == 0;
	}
}


