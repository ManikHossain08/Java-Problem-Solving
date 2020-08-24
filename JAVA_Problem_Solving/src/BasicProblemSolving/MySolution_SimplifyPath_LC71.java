package BasicProblemSolving;

import java.util.Scanner;
import java.util.Stack;

public class MySolution_SimplifyPath_LC71 {

	public static Stack<String> stack = new Stack<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputs = sc.nextLine();

		System.out.print(simplifyPath(inputs));
		sc.close();
	}

	private static String simplifyPath(String inputs) {
		String result = "";
		String[] splittedString = inputs.split("/");
		for (int i = 0; i < splittedString.length; i++) {
			String str = splittedString[i];
			if (str.contentEquals("..")) {
				if (stack.size() != 0)
					stack.pop();
			} else if (str.contentEquals(".")) {
				continue;
			} else if (!str.isEmpty() || !str.contentEquals("") || !str.isBlank()) {
				stack.add("/" + str);
			}
		}
		if (stack.size() == 0)
			return "/";
		for (int i = 0; i < stack.size(); i++) {
			result += stack.get(i);
		}

		return result;
	}
}
