package ArrayOperation_LC;

import java.util.Scanner;

public class LC1456_MaximumNumber_Vowels_Substring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int k = sc.nextInt();

		System.out.print(maxVowels(s, k));
		sc.close();
	}

	public static int maxVowels(String s, int k) {
		int count = 0;
		int max = 0;
		for (int i = 0; i < k; i++) {
			if (isVowel(s.charAt(i))) {
				count++;
				max = Math.max(max, count);
			}
		}

		int start = 0;
		for (int i = k; i < s.length(); i++) {

			if (isVowel(s.charAt(i))) {
				count++;
			}
			if (isVowel(s.charAt(start++))) {
				count--;
			}

			max = Math.max(max, count);
		}

		return max;
	}

	public static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}
