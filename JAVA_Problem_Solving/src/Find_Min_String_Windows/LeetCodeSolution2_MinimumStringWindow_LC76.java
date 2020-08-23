package Find_Min_String_Windows;

import java.util.Scanner;

public class LeetCodeSolution2_MinimumStringWindow_LC76 {

	// https://leetcode.com/problems/minimum-window-substring/

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String letter = sc.nextLine();
		System.out.print(minWindow(str, letter));

		sc.close();
	}

	public static String minWindow(String s, String t) {
		int[] count = new int[128];
		for (char c : t.toCharArray())
			count[c]++;

		int min = s.length() + 1, i = 0, j = 0, remain = t.length();

		String res = "";
		while (i < s.length()) {
			if (--count[s.charAt(i++)] >= 0)
				remain--;
			while (remain == 0) {
				if (i - j < min) {
					min = i - j;
					res = s.substring(j, i);
				}
				if (++count[s.charAt(j++)] > 0)
					remain++;
			}
		}
		return res;
	}
}
