package ValidLongestParenthesis;

import java.util.Scanner;

public class LC678_Valid_Parenthesis_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputs = sc.next();
		System.out.print(checkValidString(inputs));
		sc.close();
	}

	public static boolean checkValidString(String s) {
	    return checkValidString(s, 0, 0, 0);
	}

	public static boolean checkValidString(String s, int i, int open, int close) {
	    if(s.length() == i) return open == close;
	    if(close > open) return false;
	    switch(s.charAt(i)) {
	        case '(':
	            return checkValidString(s, i+1, open + 1, close);
	        case ')':
	            return checkValidString(s, i+1, open, close + 1);
	        case '*':
	            return checkValidString(s, i+1, open, close) ||
	                    checkValidString(s, i+1, open + 1, close) ||
	                    checkValidString(s, i+1, open, close + 1);
	    }
	    return false;
	}
}
