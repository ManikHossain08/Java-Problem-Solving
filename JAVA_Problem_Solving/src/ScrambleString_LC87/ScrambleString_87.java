package ScrambleString_LC87;

import java.util.Scanner;

public class ScrambleString_87 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		System.out.print(isScrambleString(s1, s2));
		sc.close();
	}

	private static boolean isScrambleString(String s1, String s2) {

		int[] frqMeter = new int[26];
		int strLen = s1.length();

		if (s1.equals(s2))
			return true;
		if (s1.length() != s2.length())
			return false;

		for (int i = 0; i < strLen; i++) {
			frqMeter[s1.charAt(i) - 'a']++;
			frqMeter[s2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < frqMeter.length; i++) {
			if (frqMeter[i] != 0)
				return false;
		}

		for (int i = 1; i < strLen; i++) {
			// no swapping
			if (isScrambleString(s1.substring(0, i), s2.substring(0, i))
					&& isScrambleString(s1.substring(i), s2.substring(i)))
				return true;

			// swapping //from front (first) //from back (last)
			// (because we need equal length string)
			if (isScrambleString(s1.substring(0, i), s2.substring(strLen - i))
					&& isScrambleString(s1.substring(i), s2.substring(0, strLen - i)))
				return true;
		}
		return false;
	}

}
