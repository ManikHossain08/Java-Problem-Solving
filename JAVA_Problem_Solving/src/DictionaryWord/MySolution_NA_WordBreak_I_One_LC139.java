package DictionaryWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySolution_NA_WordBreak_I_One_LC139 {
	
	// ***Note: this code did not worked for all the test cases , 35 / 43 test cases passed.
	// stop sowking for this input
	/*
	aaaaaaa
	aaaa,aaa
	 * */
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String targetstr = sc.nextLine();
		String[] words = sc.nextLine().split(",");
		List<String> wordList = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			wordList.add(words[i]);
		}

		System.out.print(isbreakable1(targetstr ,wordList));
		System.out.print(isbreakable2(targetstr ,wordList));
		sc.close();
	}
	
	private static boolean isbreakable1(String targetstr, List<String> words) {
		// TLE: 36 / 43 test cases passed.
		return helper(targetstr, words, 0, "");
	}

	private static boolean helper(String targetstr, List<String> words, int start, String string) {

		if (targetstr.length() == string.length()) {
			return true;
		}

		for (int i = start; i < targetstr.length(); i++) {
			String substr = targetstr.substring(start, i + 1);
			StringBuilder newString = new StringBuilder(string);
			newString.append(substr);
			if (words.contains(substr))
				if(helper(targetstr, words, i + 1, newString.toString()))
				return true;
		}
		return false;
	}
	
	
	private static boolean isbreakable2(String str, List<String> words) {
		// 35 / 43 test cases passed.
		if (words.size() == 0 || str.isEmpty())
			return false;
		if(words.contains(str) || words.isEmpty()) return true;
		
		int i = 0;
		boolean isbreakable = false;
		String strCopy = str, appendString = "";
		if (words.size() == 0 || str.isEmpty())
			return false;
		if (words.contains(str) || words.isEmpty())
			return true;

		for (i = 1; i <= strCopy.length() && isbreakable == false; i++) {
			String segmented = strCopy.substring(0, i);
			if (words.contains(segmented)) {
				appendString += segmented;
				strCopy = strCopy.substring(i);
				i = 0;
				if (appendString.equals(str))
					isbreakable = true;
				else isbreakable = false;
			}
		}
		return isbreakable;
	}

}

/*
aaaaaaa
aaaa,aaa

aaaaaaaa
aaaa,aaa,aa

catsandog
cats,dog,sand,and,cat
 * */
