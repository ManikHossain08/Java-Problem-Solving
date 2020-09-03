package Find_Min_String_Windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MySolution2_MinimumStringWindow_LC77 {

	// https://leetcode.com/problems/minimum-window-substring/
	// Coding Concept: https://www.youtube.com/watch?time_continue=237&v=eS6PZLjoaq8&feature=emb_logo

	public static Map<Character, Integer> originalLetter = new HashMap<Character, Integer>();
	public static Map<Character, Integer> letterCount = new HashMap<Character, Integer>();
	public static List<Character> charLetters = new ArrayList<Character>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String letter = sc.nextLine();
		System.out.print(minWindow(str, letter));
		
		sc.close();
	}

	public static String minWindow(String inputStr, String letter) {
		
		if (inputStr.length() > 70 || letter.length() > inputStr.length())
			return "";
		originalLetter = calcLetters(letter);

		return findMinimumWindows(inputStr, letter);
	}

	private static Map<Character, Integer> calcLetters(String letter) {
		
		for (int i = 0; i < letter.length(); i++) {
			char ch = letter.charAt(i);
			originalLetter.put(ch, originalLetter.getOrDefault(ch, 0) + 1);
			charLetters.add(ch); // for comparing with counted letter
			letterCount.put(ch, 0); // firstly initializing with 0.
		}
		return originalLetter;
	}

	private static String findMinimumWindows(String inputStr, String letter) {
		int left = 0;
		int right = 0;
		String minWin = "";
		while (right < inputStr.length()) {
			String minSubWin = inputStr.substring(left, right + 1);

			if (isSatifyRequirements(minSubWin, letter)) {
				if (minWin == "" || minWin.isEmpty())
					minWin = minSubWin;
				else if (minWin.length() > minSubWin.length()) {
					minWin = minSubWin;
				}
				left++;

			} else
				right++;
		}

		return minWin;
	}

	private static boolean isSatifyRequirements(String subtring, String letter) {
		letterCount = lettersInitialize(letter);
		for (int i = 0; i < subtring.length(); i++) {
			char ch = subtring.charAt(i);
			if (letterCount.containsKey(ch))
				letterCount.put(ch, letterCount.get(ch) + 1);
		}
		return checkLetterCountWithOriginal() == 1;
	}

	private static int checkLetterCountWithOriginal() {
		/*
		 * return 1 if matched both letters return 2 if exceed the limit of letter
		 * counts return -1 if nothing worked
		 */
		int flag = -1;
		for (int i = 0; i < charLetters.size(); i++) {
			char ch = charLetters.get(i);
			if (originalLetter.get(ch) <= letterCount.get(ch)) // '<=' WAS MY CHALLENGING PART AND I SPEND 
				// LOTS OF TIME FOR THIS BECAUSE I USED '==' OPERATORS SO MOST OF THE TIME IS SAYS FALSE
				flag = 1;
			else {
				flag = -1;
				break;
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
