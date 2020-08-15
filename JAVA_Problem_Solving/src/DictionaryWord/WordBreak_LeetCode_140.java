package DictionaryWord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordBreak_LeetCode_140 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		String[] arrWords = sc.nextLine().split(",");
		List<String> words = new ArrayList<String>();
		for (int i = 0; i < arrWords.length; i++) {
			words.add(arrWords[i]);
		}

		System.out.print(isWordBreakable(str, words));
		sc.close();

	}

	private static boolean isWordBreakable(String str, List<String> words) {

		if (words.size() == 0 || str.isEmpty())
			return false;
		if(words.contains(str) || words.isEmpty()) return true;
		
		Collections.sort(words, (a, b) -> {
			if (a.length() != b.length())
				return a.length() - b.length();
			return a.compareTo(b);
		});

		int segmentNo = 0, i = 0;
		String strCopy = str, appendString = "";
		while (segmentNo <= words.size()) {
			for (String word : words) {
				segmentNo++;
				if (strCopy.startsWith(word)) {
					for (i = 0; i < word.length(); i++) {
						if (strCopy.charAt(i) != word.charAt(i))
							return false;
					}
					appendString += strCopy.substring(0, i);
					strCopy = strCopy.substring(i);
				}
			}
		}
		if (appendString.equals(str))
			return true;

		return false;
	}
}

/*
 * inputs : 
 * 
 * applepenapple - apple,pen --- true
 * 
 * cars - car,ca,rs -- true
 * 
 * catsandog - cats,dog,sand,and,cat --- false
 * 
 * aaaaaaaa - aaaa,aaa,aa ---- true
 * 
 */
