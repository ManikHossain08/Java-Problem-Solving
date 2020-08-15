package DictionaryWord;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WordBreak_LC_139 {
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
	// https://leetcode.com/problems/word-break/discuss/44054/Java-DP-solution
	private static boolean isWordBreakable(String s, List<String> wordList) {

		boolean[] T = new boolean[s.length() + 1];
	    Set<String> set = new HashSet<>();
	    for (String word : wordList) {
	        set.add(word);
	    }
	    T[0] = true;
	    for (int i = 1; i <= s.length(); i++) {
	        for (int j = 0; j < i; j++) {
	            if(T[j] && set.contains(s.substring(j, i))) {
	                T[i] = true;
	                break;
	            }
	        }
	    }
	    return T[s.length()];
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
