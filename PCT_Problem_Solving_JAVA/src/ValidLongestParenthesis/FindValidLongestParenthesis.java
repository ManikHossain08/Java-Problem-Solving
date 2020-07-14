package ValidLongestParenthesis;

import java.util.Scanner;

public class FindValidLongestParenthesis {
	public static void main(String args[]) {
		// Online problem link: https://leetcode.com/problems/longest-valid-parentheses/
		Scanner sc_in = new Scanner(System.in);
		String inputStr = sc_in.nextLine(); // ")()())"

		System.out.print(longestValidParentheses(inputStr));
		sc_in.close();
	}

	// Another Important:
	// https://www.geeksforgeeks.org/median-two-sorted-arrays-different-sizes-ologminn-m/
	public static int longestValidParentheses(String s) {
		int count = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			count = 0;
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(j) == '(') {
					count++;
				} else {
					count--;
				}
				if (count < 0) {
					break;

				}
				if (count == 0) {
					if (j - i + 1 > max) {
						max = j - i + 1;
					}
				}
			}
		}
		return max;
	}
}
