package StringOperation;

import java.util.Scanner;

public class LC1540_Can_Convert_String_in_K_Moves {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		int k = sc.nextInt();

		System.out.print(canConvertString(s, t, k));
		sc.close();

	}

	public static boolean canConvertString(String s, String t, int k) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] a = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int val = (t.charAt(i) + 26 - s.charAt(i)) % 26;
			if (a[val] != 0) {
				val = a[val] + 26;
			}
			a[val % 26] = val;
			if (val > k) {
				return false;
			}
		}
		return true;
	}

}
