package DictionaryWord;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ReplaceWord_LeetCodeSolution_648 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String[] arrWords = sc.nextLine().split(",");
		List<String> words = new ArrayList<String>();
		for (int i = 0; i < arrWords.length; i++) {
			words.add(arrWords[i]);
		}
		String sentence = sc.nextLine();
		System.out.print(replaceWords(words, sentence));
		sc.close();
	}

	private static String replaceWords(List<String> dict, String sentence) {
		// Collections.sort(dict, Comparator.comparingInt(a -> a.length()));

		Collections.sort(dict, (a, b) -> {
			if (a.length() != b.length())
				return a.length() - b.length();
			return a.compareTo(b);
		});

		String[] words = sentence.split(" ");
		StringBuilder sb = new StringBuilder();

		for (String senWord : words) {
			for (String dictWord : dict) {
				if (senWord.startsWith(dictWord)) {
					senWord = dictWord;
					break;
				}
			}
			sb.append(senWord + " ");
		}
		sb.replace(sb.length() - 1, sb.length(), ""); // remove blank space in the end
		return sb.toString();
	}
}
// [bat, rat, cat, catt]