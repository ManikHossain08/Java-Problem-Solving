package StringOperation;

import java.util.Scanner;

public class LC5_Palindromic_MaxSubstrings {
	
	static String maxStr = "";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		System.out.print(longestPalindrome(str1));
		sc.close();
	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return "";
		
		for (int i = 0; i < s.length(); i++) { // i is the mid point
			longestPalindrome(s, i, i); // odd length;
			longestPalindrome(s, i, i + 1); // even length
		}

		return maxStr;
	}

	private static void longestPalindrome(String s, int left, int right) {

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			if (maxStr.length() < s.substring(left, right + 1).length()) {
				maxStr = s.substring(left, right + 1);
			}
			left--;
			right++;
		}
	}
}
