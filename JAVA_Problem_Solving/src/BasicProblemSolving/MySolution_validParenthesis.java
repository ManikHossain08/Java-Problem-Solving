package BasicProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySolution_validParenthesis {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int inp = sc.nextInt();
		List<String> result = new ArrayList<String>();
		generateValidParenthesis(inp, inp, "", result, "");
		System.out.println(result);
		sc.close();

	}

	private static List<String> generateValidParenthesis(int left, int right, String s, List<String> result,
			String res) {

		if (left > right)
			return null;

		res = res + s;

		if (left == 0 && right == 0) {
			result.add(res);
			return null;
		}

		if (left > 0)
			generateValidParenthesis(left - 1, right, "(", result, res);
		if (right > 0)
			generateValidParenthesis(left, right - 1, ")", result, res);
		
		return result;
	}
}
