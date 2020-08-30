package SubstringWithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MySolution_LC30 {
	public static Map<String, Integer> wordList = new HashMap<String, Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] words = sc.nextLine().split(",");
		System.out.print(findSubstring(str, words));
		sc.close();

	}

	private static List<Integer> findSubstring(String str, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if (words.length == 0 || str.isEmpty() || str.contentEquals("") || words[0].contentEquals(""))
			return new ArrayList<Integer>();

		int eachWordLength = words[0].length();
		for (int i = 0; i < words.length; i++) {
			wordList.put(words[i], wordList.getOrDefault(words[i], 0) + 1);
		}
		getSubStringIndex(str, result, eachWordLength, words.length);

		return result;
	}

	private static List<Integer> getSubStringIndex(String str, List<Integer> result, int eachWordLength, int wordsNum) {
		int fullStrLength = eachWordLength * wordsNum;
		
		for (int startingIndex = 0; startingIndex < str.length(); startingIndex++) {
			if (str.length() < startingIndex + fullStrLength) return result;
			
			String fullSubString = str.substring(startingIndex, startingIndex + fullStrLength);
			
			Map<String, Integer> wordListCopy = new HashMap<String, Integer>(wordList);
			
			for (int i = 0; i < fullSubString.length(); i = i + eachWordLength) {
				String singleWord = fullSubString.substring(i, i + eachWordLength);
				
				if (wordListCopy.containsKey(singleWord)) {
					int count = wordListCopy.get(singleWord);
					if(count == 1) wordListCopy.remove(singleWord);
					else wordListCopy.put(singleWord, count-1);
				} else break;
			}
			if (wordListCopy.size() == 0) result.add(startingIndex);
		}
		return result;
	}
}

// wordgoodgoodgoodbestword
// word,good,best,good - [8]

// "barfoofoobarthefoobarman"
// bar,foo,the - [6, 9, 12]
