package ValidLongestParenthesis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LC_Soln_RemoveInvalidParenthesis_LC301 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputs = sc.nextLine();
		System.out.print(removeInvalidParentheses(inputs));
		sc.close();
	}

	private static List<String> removeInvalidParentheses(String s) {
		List<String> ret = new ArrayList<>();
		if (s == null) new ArrayList<>();
		List<String> candidates = new LinkedList<>();
		Set<String> tried = new HashSet<>();
		candidates.add(s);
		while (!candidates.isEmpty()) {
			for (String p : candidates) {
				if (isValidParenthesis(p))
					ret.add(p);
			}
			if (!ret.isEmpty())
				return ret;
			List<String> nextLevel = new LinkedList<>();
			for (String p : candidates) {
				for (int i = 0; i < p.length(); ++i) {
					if (p.charAt(i) != '(' && p.charAt(i) != ')')
						continue;
					// bug - 2 => it's okay to have p.substring(0, 0) and p.substring(p.length());
					String t = p.substring(0, i) + p.substring(i + 1);
					if (tried.contains(t))
						continue;
					nextLevel.add(t);
					tried.add(t);
				}
			}
			candidates = nextLevel;
		}
		return ret;
	}

	private static boolean isValidParenthesis(String inputs) {
		int count = 0;
		for (int i = 0; i < inputs.length(); i++) {
				char ch = inputs.charAt(i);
				//if(ch != ')' || ch != '(') continue;
				if (ch == '(') count++;
				if (ch == ')') count--;
				if(count < 0) return false;
		}
		return count == 0;
	}
}

//["(a)()()", "(a())()"]
