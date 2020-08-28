package ValidLongestParenthesis;

import java.util.Scanner;

public class MySolution_ValidParenthesis_LC32 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputs = sc.nextLine();
		System.out.print(getValidParenthesis(inputs));
		sc.close();
	}

	private static int getValidParenthesis(String inputs) {
		int lrCounter = 0;
		int max = 0;
		for (int i = 0; i < inputs.length(); i++) {
			lrCounter = 0;
			for (int j = i; j < inputs.length(); j++) {
				char ch = inputs.charAt(j);
				if (ch == '(') lrCounter++;
				if (ch == ')') lrCounter--;
				if(lrCounter < 0) break;
				if (lrCounter == 0) {
					max = Math.max(max, j - i + 1);
				}
			}
		}

		return max;
	}
}
