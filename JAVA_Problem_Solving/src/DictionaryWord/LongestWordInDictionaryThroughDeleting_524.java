package DictionaryWord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LongestWordInDictionaryThroughDeleting_524 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arrWords = sc.nextLine().split(",");
		List<String> words = new ArrayList<String>();

		for (int i = 0; i < arrWords.length; i++) {
			words.add(arrWords[i]);
		}

		System.out.print(findLongestWord(str, words));
		sc.close();
	}

	private static String findLongestWord(String s, List<String> d) {
		if (s.length() == 0 || d.size() == 0)
			return "";

		Collections.sort(d, (a, b) -> {
			if (a.length() != b.length())
				return b.length() - a.length();
			return a.compareTo(b);
		});

		for (String p : d) {
			if (s.length() < p.length())
				continue;
			if (isSubSeq(s, p))
				return p;
		}

		return "";
	}

	private static boolean isSubSeq(String s, String p) {
		int i = 0, j = 0;
		while (i < s.length() && j < p.length()) {
			if (s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
			}
		}
		return j == p.length();
	}
}
