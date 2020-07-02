package predictPattern_N_Gram_Problem;

import java.util.Scanner;
import java.util.StringTokenizer;

public class PredictPattern_N_Gram_Problem {
	public static void main(String args[]) {

		// This code allows a user to read a number for input lines from System.in
		@SuppressWarnings("resource")
		Scanner sc_in = new Scanner(System.in);
		int lines = sc_in.nextInt();
		// Running loop to get all input lines
		String input = "";
		for (int i = 0; i <= lines; i++) {
			input += " " + sc_in.nextLine();
		}
		int ngram = sc_in.nextInt();
		if (ngram < 1 || ngram > 3) {
			System.out.println(ngram + "-Gram is not available. please try between 1-3.");
			return;
		}
		// System.out.print(input.strip());
		// Tutorial#4 could not solved, need to think about it later because its very
		// very difficult problem
		// **** How to generate N-Gram:
		// https://www.educative.io/edpresso/how-to-generate-an-n-gram-in-java

		// System.out.println("Using Constructor 3 - ");

		switch (ngram) {
		case 1:
			UniGramPatternsPredictions(input);
			break;
		case 2:
			BiGramPatternsPredictions(input);
			break;
		case 3:
			TriGramPatternsPredictions(input);
			break;
		}

	}

	private static void UniGramPatternsPredictions(String input) {
		int[] uni = new int[26];
		int besti = 0;

		StringTokenizer token = new StringTokenizer(input, " ");
		while (token.hasMoreTokens()) {
			String word = token.nextToken();
			for (int i = 0; i < word.length(); i++) {
				// charAt function returns the char value at the specified index.
				uni[word.charAt(i) - 'a']++; // e.g: 'c' - 'a' = 3-1 = 2 is the third position of the array for c
			}
		}
		int best = uni[0];
		for (int i = 0; i < uni.length; i++) {
			if (uni[i] > best) {
				besti = i; // finding position of that specific character
				best = uni[i];
			}
		}
		System.out.println("Unigram " + (char) (besti + 'a'));
		// from index position back to the character position, e.g: 2+1 = 3 = c

	}

	private static void BiGramPatternsPredictions(String input) {
		int[][] bigram = new int[26][26];
		int besti = 0;
		int bestj = 0;

		StringTokenizer token = new StringTokenizer(input, " ");
		while (token.hasMoreTokens()) {
			String word = token.nextToken();
			word = removeUnwantedCharater(word);
			for (int i = 1; i < word.length(); i++) {
				// charAt function returns the char value at the specified index.
				bigram[word.charAt(i - 1) - 'a'][word.charAt(i) - 'a']++;
			}

		}
		int best = bigram[0][0];
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if (bigram[i][j] > best) {
					besti = i; // finding position of that specific character
					bestj = j;
					best = bigram[i][j];
				}
			}
		}
		System.out.println("Bigram " + (char) (besti + 'a') + (char) (bestj + 'a'));

	}

	private static void TriGramPatternsPredictions(String input) {
		int[][][] bigram = new int[26][26][26];
		int besti = 0;
		int bestj = 0;
		int bestk = 0;

		StringTokenizer token = new StringTokenizer(input, " ");
		while (token.hasMoreTokens()) {
			String word = token.nextToken();
			word = removeUnwantedCharater(word);
			for (int i = 2; i < word.length(); i++) {
				// charAt function returns the char value at the specified index.
				bigram[word.charAt(i - 2) - 'a'][word.charAt(i - 1) - 'a'][word.charAt(i) - 'a']++;
			}

		}
		int best = bigram[0][0][0];
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				for (int k = 0; k < 26; k++) {
					if (bigram[i][j][k] > best) {
						besti = i; // finding position of that specific character
						bestj = j;
						bestk = k;
						best = bigram[i][j][k];
					}
				}
			}
		}
		System.out.println("Trigram " + (char) (besti + 'a') + (char) (bestj + 'a') + (char) (bestk + 'a'));

	}

	private static String removeUnwantedCharater(String str) {
		str = str.replaceAll("[^a-zA-Z0-9]", "").strip();
		return str;

	}

}
