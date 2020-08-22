package FindPossibleStringCombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MySolution_PossibleStringCombination {
	public static String[][] inpArr = null;
	public static int lines = 0;
	public static List<String> combinationList = new ArrayList<String>();
	private static List<String> ALLCOMBINATION = new ArrayList<String>();
	private static List<String> allRotatedTargetString = new ArrayList<String>();

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		lines = sc.nextInt();

		sc.nextLine(); // This line will removes the extra \n after first integer input.
		// without this line it get null pointer exception
		inpArr = new String[lines][];
		for (int i = 0; i < lines; i++) {
			inpArr[i] = sc.nextLine().split(",");
		}
		String targetStr = sc.nextLine();
		sc.close();
		
		getrotatedTargetString(targetStr);
		findWordsForCombinations(new ArrayList<String>(), 0);
		gelAllCombinationList();
		matchCombinationWithTargetString();
		
	}
	
	
	private static void getrotatedTargetString(String targetStr) {
		int strLen = targetStr.length();
		for (int i = 0; i < strLen; i++) {
			char ch = targetStr.charAt(0);
			String newtargetStr = targetStr.substring(1, strLen);
			targetStr = newtargetStr + ch;
			allRotatedTargetString.add(targetStr);
		}
	}
	// THIS IS FOR FINDING COMBINATION FROM 2D ARRAY.
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
			 */
		}
		return combinationList;
	}
	
	private static void gelAllCombinationList() {
		for (int i = 0; i < combinationList.size(); i = i + lines) {
			List<String> wordList = new ArrayList<String>();
			for (int j = 0; j < lines; j++) {
				wordList.add(combinationList.get(i + j));
			}
			ArrayList<String> singleCobination = new ArrayList<String>();
			getCombinationWithSlecetedWordList("", wordList, singleCobination);
			ALLCOMBINATION.addAll(singleCobination);
		}
	}
	// THIS IS FOR FINDING COMBINATION FROM 1D ARRAY.
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


	private static void matchCombinationWithTargetString() {
		ArrayList<String> acceptedCombinations = new ArrayList<String>();
		for (int i = 0; i < ALLCOMBINATION.size(); i++) {
			String singleCombinatioin = ALLCOMBINATION.get(i);

			for (int j = 0; j < allRotatedTargetString.size(); j++) {
				if (singleCombinatioin.contains(allRotatedTargetString.get(j))) {
					acceptedCombinations.add(singleCombinatioin);
					break;
				}
			}
		}
		
		Collections.sort(acceptedCombinations);
		for (int i = 0; i < acceptedCombinations.size(); i++) {
			if (i < acceptedCombinations.size() - 1)
				System.out.println(acceptedCombinations.get(i));
			else
				System.out.print(acceptedCombinations.get(i));
		}
	}
	
}
