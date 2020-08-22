package JAVANotesDP;


public class JavaNotesForDP {
	// https://www.youtube.com/watch?v=qyu4q3-glLU
	// listen this video for when using DP or when we should follow DP in problem solving
	
	
	// NOTE: for finding the combination from 2d array use this code 
	// Solution-1 : PHONE NUMBER LETTER COMBINATION
	/*
	 public static List<String> findCombinations(String digits, String Combination, int index) {

		if (index == digits.length()) {
			result.add(Combination);
			return null;
		}
		String[] getLetter = letters[digits.charAt(index) - '0'];

		for (int j = 0; j < getLetter.length; j++) {
			findCombinations(digits, Combination + getLetter[j] + "", index + 1);
			
		}
		return result;
	}
	 */
	
	
	/* Solution-2:
	 public static List<String> findWordsForCombinations(List<String> singleCombination, int index) {

		if (index == inpArr.length) {
			combinationList.addAll(singleCombination);
			return null;
		}

		String[] getLetter = inpArr[index];
		for (int j = 0; j < getLetter.length; j++) {
			singleCombination.add(getLetter[j]);
			findWordsForCombinations(singleCombination, index + 1);
			singleCombination.remove(getLetter[j]);
			/*
			 * if we use StringBuilder or List for storing combination then we have to remove 
			 * the last word from the list for second combination before adding to the final
			 * result list... please see alternative solution of same problem.
			 
		}
		return combinationList;
	}
	 */
	
	
	// NOTE: for finding the combination from 1d array or list of words use this code 
	
	/*
	 private static void getCombinationWithSlecetedWordList(String singleComb, List<String> wordList,
			ArrayList<String> result) {

		if (wordList.size() == 0) {
			result.add(singleComb);
		}

		for (int i = 0; i < wordList.size(); i++) {
			String newSingleComb = singleComb + wordList.get(i);
			ArrayList<String> newwordList = new ArrayList<>(wordList);
			newwordList.remove(i);
			getCombinationWithSlecetedWordList(newSingleComb, newwordList, result);
		}
	}
	 */
	
	
	// see findPossibleStringCombination problem
	
	
}
