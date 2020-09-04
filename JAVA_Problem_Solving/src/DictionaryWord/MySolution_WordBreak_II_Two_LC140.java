package DictionaryWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySolution_WordBreak_II_Two_LC140 {
	// concept: https://leetcode.com/problems/word-break-ii/discuss/44191/Java-DP-solution
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String orgtargetstr = sc.nextLine();
		
		List<String> wordList = new ArrayList<String>();
		String[] words = sc.nextLine().split(",");
		
		for (int i = 0; i < words.length; i++) {
			wordList.add(words[i]);
		}

		System.out.print(wordBreakTwo(orgtargetstr, wordList));
		sc.close();
	}

	private static List<String> wordBreakTwo(String targetstr, List<String> words) {
		List<String> result = new ArrayList<String>();
		if(targetstr.isEmpty())
            return result; // return empty list upon empty string

		return helper(targetstr, words, 0, "", result);
	}

	private static List<String> helper(String targetstr, List<String> words, int index, String string,
			List<String> result) {

		if (targetstr.length() - 1 == index) {
			result.add(string.strip());
			return result;
		}

		for (int i = index; i < targetstr.length(); i++) {
			String substr = targetstr.substring(index, i + 1);
			if (words.contains(substr))
				helper(targetstr, words, i + 1, string + substr + " ", result);
		}
	
	  return result;
	}
}

/*
pineapplepenapple 
apple,pen,applepen,pine,pineapple
 * 
catsanddog 
cat,cats,and,sand,dog
 * 
catsandog 
cats,dog,sand,and,cat
 */
