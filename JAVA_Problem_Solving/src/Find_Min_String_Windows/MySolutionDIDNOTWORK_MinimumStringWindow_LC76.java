package Find_Min_String_Windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MySolutionDIDNOTWORK_MinimumStringWindow_LC76 {
	
	// https://leetcode.com/problems/minimum-window-substring/
	// NOTE: THIS CODE IS WORKING FOR FIRST 2 TEST CASES BUT FOR 3RD TEST CASE 
	// IT IS NOT WORKING SO THIS SOLUTION IS NOT EEFICIENT
	
	public static Map<Character, Integer> originalLetter = new HashMap<Character, Integer>();
	public static Map<Character, Integer> letterCount = new HashMap<Character, Integer>();
	//public static Map<String, Integer> windows = new HashMap<String, Integer>();
	public static List<Character> charLetters = new ArrayList<Character>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String letter = sc.nextLine();
		System.out.print(minWindow(str, letter));
		//System.out.print(windows);
		sc.close();
	}

	public static String minWindow(String inputStr, String letter) {
		originalLetter = calcLetters(letter);

		return findMinimumWindows(inputStr, letter);
	}

	private static Map<Character, Integer> calcLetters(String letter) {
		Map<Character, Integer> orgLettersCount = new HashMap<Character, Integer>();
		letterCount = new HashMap<Character, Integer>();
		charLetters = new ArrayList<Character>();

		for (int i = 0; i < letter.length(); i++) {
			char ch = letter.charAt(i);
			if (!orgLettersCount.containsKey(ch))
				orgLettersCount.put(ch, 1);
			else
				orgLettersCount.put(ch, orgLettersCount.get(ch) + 1);
			charLetters.add(ch);
			letterCount.put(ch, 0);
		}
		return orgLettersCount;
	}

	private static String findMinimumWindows(String inputStr, String letter) {
		int left = 0;
		int right = 0;
		String minWin = "";
		for (int i = 0; i < inputStr.length(); i++) {
			char ch = inputStr.charAt(i);
			if (originalLetter.containsKey(ch)) {
				letterCount.put(ch, letterCount.get(ch) + 1);
				if (left == 0)
					left = i;
				// if all letter found
				if (checkLetterCountWithOriginal(1) == 1) {
					right = i;
					if (minWin == "" || minWin.isEmpty())
						minWin = inputStr.substring(left, right + 1);
					else if (minWin.length() > inputStr.substring(left, right).length()) {
						minWin = inputStr.substring(left, right+1);
					}
					//windows.put(minWin, minWin.length());
					left = 0;
				}
				// if found more letter
				else if (checkLetterCountWithOriginal(2) == 2) {
					letterCount = lettersInitialize(letter);
					letterCount.put(ch, letterCount.get(ch) + 1);
					left = i;
				}
			}
		}
		return minWin;
	}

	private static int checkLetterCountWithOriginal(int indicator) {
		/*
		 * return 1 if matched both letters return 2 if exceed the limit of letter
		 * counts return -1 if nothing worked
		 */
		int flag = -1;
		if (indicator == 1) {
			for (int i = 0; i < charLetters.size(); i++) {
				char ch = charLetters.get(i);
				if (originalLetter.get(ch) == letterCount.get(ch))
					flag = 1;
				else {
					flag = -1;
					break;
				}
			}
		}
		if (indicator == 2) {
			for (int i = 0; i < charLetters.size(); i++) {
				char ch = charLetters.get(i);
				if (originalLetter.get(ch) < letterCount.get(ch)) {
					flag = 2;
					break;
				}
			}
		}

		return flag;
	}

	private static Map<Character, Integer> lettersInitialize(String letter) {
		letterCount = new HashMap<Character, Integer>();
		for (int i = 0; i < letter.length(); i++) {
			char ch = letter.charAt(i);
			letterCount.put(ch, 0);
		}
		return letterCount;
	}
}
