package Bracketmaching;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Bracketmatching {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] inputArr = new String[n];
		for (int i = 0; i < n; i++) {
			inputArr[i] = sc.nextLine();
		}
		sc.close();
		for (String s : inputArr) {
			System.out.println(findbracketMatching(s) ? "TRUE" : "FALSE");
		}
	}

	static boolean findbracketMatching(String input) {
		String openingBrackets = "([{";
		String closingBrackets = ")]}";
		HashMap<Character, Character> matchBrackets = new HashMap<Character, Character>();
		Stack<Character> bstack = new Stack<Character>();
		matchBrackets.put(')', '(');
		matchBrackets.put('}', '{');
		matchBrackets.put(']', '[');
		for (int i = 0; i < input.length(); i++) {
			char letter = input.charAt(i);
			if (openingBrackets.indexOf(letter) != -1) {
				bstack.push(letter);
			} else if (closingBrackets.indexOf(letter) != -1) {
				if (bstack.size() == 0) {
					return false;
				} else if (bstack.peek() == matchBrackets.get(letter)) {
					bstack.pop();
				} else
					return false;
			}
		}
		return bstack.size() == 0;
	}

}
