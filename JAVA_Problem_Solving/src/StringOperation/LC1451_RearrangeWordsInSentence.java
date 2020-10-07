package StringOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LC1451_RearrangeWordsInSentence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputs = sc.nextLine();

		System.out.print(arrangeWords(inputs));
		sc.close();

	}

	private static String arrangeWords(String text) {

		String[] words = text.split(" ");
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			result.add(words[i].toLowerCase());
		}
		
		// THIS CODE WILL OREDER BY LEXIOGRAPHICAL ORDER MEANS IF THE WORD LENGTH IS SAME THEN
		// COMPARE THE CHAR LENGTH AND ORDER ACCORDINGLY
		/*
		 * THIS CODE ALSO IMPORTANT FOR ANOTHER CONCEPT
		 * 
		Collections.sort(result, (a, b) -> {
			if (a.length() != b.length())
				return a.length() - b.length() ;
			return a.compareTo(b);
		});
		*/
		
		// THIS CODE ORDER INCREASING ORDER BUT IF THE WORD LENGTH EQUAL TO EACH OTHER 
		// THEN KEEP THE ORDER SAME.
		Collections.sort(result, Comparator.comparingInt(a -> a.length()));
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + " ");
		}
		String firstChar = sb.charAt(0) + "";
		String ch = firstChar.toUpperCase()+"";
		sb.setCharAt(0, ch.charAt(0)); 

		
		return sb.toString().strip();
	}

}
