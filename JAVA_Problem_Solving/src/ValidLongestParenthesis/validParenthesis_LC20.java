package ValidLongestParenthesis;

import java.util.Scanner;
import java.util.Stack;

public class validParenthesis_LC20 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputs = sc.nextLine();
		System.out.print(isValidParenthesis(inputs));
		sc.close();
	}

	private static boolean isValidParenthesis(String inputs) {
		
		if(inputs.length() == 1) return false;
		
		Stack<Character> parenthesis = new Stack<Character>();

		for (int i = 0; i < inputs.length(); i++) {
				char ch = inputs.charAt(i);
				if (ch == '(') parenthesis.add(')');
				else if (ch == '{')  parenthesis.add('}');
				else if (ch == '[')  parenthesis.add(']');
				else if(parenthesis.isEmpty()) return false;
				else if (parenthesis.pop() != ch) return false;
		}

		return parenthesis.isEmpty();
	}
}
