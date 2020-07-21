package BasicProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {
	public static void main(String args[]) {
		// Backtracking is a DFS search: https://www.youtube.com/watch?v=DKCbsiDBN6c
		// Brunch and bound is BFS search: https://www.youtube.com/watch?v=DKCbsiDBN6c
		Scanner sc = new Scanner(System.in);
		int inputPair = sc.nextInt();

		System.out.print(generateParenthesis(inputPair));
		sc.close();
	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		backtrack(n, n, "", res);
		return res;
	}
	// This is depth first search 
	private static void backtrack(int left, int right, String s, List<String> res) {
		// Means closing bracket already put indicate invalid format and it excluded from list.
		if (left > right) 
			return;
		if (left == 0 && right == 0) {
			res.add(s);
			return;
		}

		// "left" or "right" means how many left or right parentheses could be used here
		if (left > 0)
			backtrack(left - 1, right, s + "(", res);
		if (right > 0)
			backtrack(left, right - 1, s + ")", res);
	}

}
