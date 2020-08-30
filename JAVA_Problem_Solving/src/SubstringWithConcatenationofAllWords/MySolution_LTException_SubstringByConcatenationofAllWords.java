package SubstringWithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MySolution_LTException_SubstringByConcatenationofAllWords {
	
	// this code: 148 / 173 test cases passed.
	// I developed this code first.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] words = sc.nextLine().split(",");
		System.out.print(findSubstring(str, words));
		sc.close();

	}

	private static List<Integer> findSubstring(String str, String[] words) {
		
		if(words.length == 0 || str.isEmpty() || str.contentEquals("") || words[0].contentEquals("")) 
			return new ArrayList<Integer>();
		
		List<Integer> result = new ArrayList<Integer>();
		List<String> wordList = new ArrayList<String>();
		int wordTotalLength = 0;
		for (int i = 0; i < words.length; i++) {
			wordList.add(words[i]);
			wordTotalLength += words[i].length();
		}
		Map<String, String> combinations = new HashMap<String, String>();
		if(wordList.size() > 0) {
			combinations = findConbinationOfWords("", wordList, combinations);
		}
		getSubString(str, combinations, result, wordTotalLength);

		return result;
	}

	private static Map<String, String> findConbinationOfWords(String combination, List<String> newWordList,
			Map<String, String> result) {
		if (newWordList.size() == 0)
			result.put(combination, combination);
		for (int i = 0; i < newWordList.size(); i++) {
			List<String> word = new ArrayList<String>(newWordList);
			String newCombination = combination + word.get(i);
			word.remove(i);
			findConbinationOfWords(newCombination, word, result);
		}

		return result;
	}

	private static List<Integer> getSubString(String str, Map<String, String> combinations, List<Integer> result,
			int length) {
		int StringLength = str.length();
		int right = 0;
		while (right < StringLength) {
			int nextLength = right + length;
			if (nextLength > StringLength) return result;
			
			String subtring = str.substring(right, nextLength);
			if (combinations.containsKey(subtring)) result.add(right);
			
			right++;
		}

		return result;
	}

}



