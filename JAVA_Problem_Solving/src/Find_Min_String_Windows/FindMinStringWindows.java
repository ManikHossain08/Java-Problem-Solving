package Find_Min_String_Windows;

import java.util.HashMap;
import java.util.Scanner;

public class FindMinStringWindows {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String inputStr = input.nextLine();
		String letterStr = input.nextLine();

		String minWinStr = getMinWindowsString(inputStr, letterStr);
		System.out.print(minWinStr);
		input.close();

	}

	private static String getMinWindowsString(String inputStr, String letterStr) {
		String minWinStr = "";
		if (inputStr.length() > 70 || letterStr.length() > inputStr.length())
			return "";

		int start_Sliding_win = 0;
		int foundedCharFreq = 0;
		int minWinSize = inputStr.length();

		HashMap<Character, Integer> hash_str = new HashMap<Character, Integer>(); // input string value
		HashMap<Character, Integer> hash_pat = new HashMap<Character, Integer>(); // searched

		for (int let = 0; let < letterStr.length(); let++) {
			char ch = letterStr.charAt(let);
			if (hash_pat.containsKey(ch)) {
				hash_pat.put(ch, hash_pat.get(ch) + 1);
			} else {
				hash_pat.put(ch, 1);
			}
		}

		for (int i = 0; i < inputStr.length(); i++) {
			char ch = inputStr.charAt(i);
			if (hash_pat.containsKey(ch)) {
				if (hash_str.containsKey(ch)) {
					if (hash_str.get(ch) < hash_pat.get(ch)) {
						foundedCharFreq++;
					}
					hash_str.put(ch, hash_str.get(ch) + 1);
				} else {
					hash_str.put(ch, 1);
					foundedCharFreq++;
				}
			}

			if (foundedCharFreq == letterStr.length()) {
				char scan = inputStr.charAt(start_Sliding_win);
				while (!hash_str.containsKey(scan) || hash_str.get(scan) > hash_pat.get(scan)) {
					if (hash_str.containsKey(scan) && hash_str.get(scan) > hash_pat.get(scan)) {
						hash_str.put(scan, hash_str.get(scan) - 1);
					}
					start_Sliding_win++;
					scan = inputStr.charAt(start_Sliding_win);
				}

				if (i - start_Sliding_win < minWinSize) { // this condition finding min win size
					minWinStr = inputStr.substring(start_Sliding_win, i + 1);
					minWinSize = i - start_Sliding_win;
				}

			}

		}
		return minWinStr;
	}

}
