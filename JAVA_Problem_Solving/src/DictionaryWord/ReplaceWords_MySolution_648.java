package DictionaryWord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReplaceWords_MySolution_648 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String[] arrWords = sc.nextLine().split(",");
		List<String> words = new ArrayList<String>();
		for (int i = 0; i < arrWords.length; i++) {
			words.add(arrWords[i]);
		}

		String[] strSentence = sc.nextLine().split(" ");
		StringBuilder result = new StringBuilder();
		for (String str : strSentence) {
			result.append(findLongestWord(str, words) + " ");
		}
		String replaceSentence = result.toString();
		System.out.print(replaceSentence.toString().strip());
		sc.close();
	}

	private static String findLongestWord(String s, List<String> d) {
		if (s.length() == 0 || d.size() == 0)
			return s;

		Collections.sort(d, (a, b) -> {
			if (a.length() != b.length())
				return a.length() - b.length();
			return a.compareTo(b);
		});

		for (String p : d) {
			if (s.length() < p.length())
				continue;
			if (isSubSeq(s, p))
				return p;
		}

		return s;
	}

	private static boolean isSubSeq(String s, String p) {
		int i = 0, j = 0;
		while (i < s.length() && j < p.length()) {
			if (s.charAt(i) == p.charAt(j)) {
				j++;
			}
			i++;
		}
		return j == p.length();
	}
}
