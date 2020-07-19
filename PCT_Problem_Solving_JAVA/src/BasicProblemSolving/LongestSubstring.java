package BasicProblemSolving;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstring {
	// private static

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		String inpStr = sc.nextLine();

		System.out.print(findLongestSubstring(inpStr));
		sc.close();
	}

	private static int findLongestSubstring(String inpStr) {
		int length = inpStr.length();
		int strLength = 0;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j <= length; j++) {
				if (findUniqeness(inpStr, i, j)) {
					strLength = Math.max(strLength, j - i);
				}
			}
		}
		return strLength;
	}

	private static boolean findUniqeness(String inpStr, int start, int end) {
		HashMap<Character, Integer> maping = new HashMap<Character, Integer>();
		// Set<Character> maping = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = inpStr.charAt(i);
			if (maping.containsKey(ch))
				return false;
			maping.put(ch, 1);

		}
		return true;
	}

}
