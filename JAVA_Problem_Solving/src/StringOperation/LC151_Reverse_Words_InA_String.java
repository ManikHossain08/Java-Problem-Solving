package StringOperation;

import java.util.Scanner;

public class LC151_Reverse_Words_InA_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		System.out.print(reverseWords(sentence));
		sc.close();
	}

	private static String reverseWords(String sentence) {
		StringBuilder sb = new StringBuilder();
		String[] words = sentence.split(" ");
		for (int i = words.length - 1; i >= 0; i--) {
			String singleword = words[i].strip();
			if (!singleword.isBlank() || !singleword.isEmpty())
				sb.append(words[i] + " ");
		}

		return sb.toString().strip();
	}
}
// a good   example