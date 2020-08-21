package FindPossibleStringCombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlternativeSolutionUsingDFS {

	private static int lines = 0;
	private static String[][] blocks2D;
	private static List<String> result = new ArrayList<String>();
	private static List<String> ALLCOMBINATION = new ArrayList<String>();

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		lines = sc.nextInt();
		sc.nextLine(); // This removes the extra \n after first integer input.

		blocks2D = new String[lines][];
		for (int i = 0; i < lines; i++) {
			// Generating 2D array from here like [[a,b,c], [d,e,f]]
			blocks2D[i] = sc.nextLine().split(",");
		}
		String targetStr = sc.nextLine();

		ArrayList<String> allRotatedTargetString = getrotatedTargetString(targetStr);

		findCombinationsDFS(new ArrayList<String>(), 0);

		for (int i = 0; i < result.size(); i = i + lines) {
			List<String> remaining = new ArrayList<String>();
			for (int j = 0; j < lines; j++) {
				String value = result.get(i + j);
				remaining.add(value);
			}

			ArrayList<String> singleCobination = new ArrayList<String>();
			getAllCombination("", remaining, singleCobination);

			for (int j = 0; j < singleCobination.size(); j++) {
				ALLCOMBINATION.add(singleCobination.get(j));
			}
		}

		findAccetpedMatchedString(ALLCOMBINATION, allRotatedTargetString);

		sc.close();
	}

	// reverse string
	private static ArrayList<String> getrotatedTargetString(String targetStr) {
		ArrayList<String> targetColl = new ArrayList<String>();
		int strLen = targetStr.length();
		for (int i = 0; i < strLen; i++) {
			char ch = targetStr.charAt(0);
			String newtargetStr = targetStr.substring(1, strLen);
			targetStr = newtargetStr + ch;
			targetColl.add(targetStr);
		}
		return targetColl;
	}

	public static void findCombinationsDFS(List<String> singleCombination, int index) {
		if (index == lines) {
			result.addAll(singleCombination);
			return;
		}
		// Note: THIS COMMENTED CODE IS ASSOCIATED WITH COMMNETED ARRAY IN THE TOP LINE
		// String str = chars[digits.charAt(index) - '0'];
		// for (char c : str.toCharArray()) {

		String[] strList = blocks2D[index];
		for (String s : strList) {
			singleCombination.add(s);
			findCombinationsDFS(singleCombination, index + 1);
			singleCombination.remove(index);
		}
	}

	// *** Important: remember this code for permutation that meant combination of
	// several words and make different string
	private static void getAllCombination(String selected, List<String> remaining, ArrayList<String> permutations) {
		// int numRemaining = remaining.size();
		if (remaining.size() == 0)
			permutations.add(selected);

		for (int i = 0; i < remaining.size(); i++) {
			String newSelected = selected + remaining.get(i);
			ArrayList<String> newRemaining = new ArrayList<>(remaining);
			newRemaining.remove(i);
			getAllCombination(newSelected, newRemaining, permutations);
		}

	}

	private static void findAccetpedMatchedString(List<String> combinations, ArrayList<String> allRotatedTargetString) {
		ArrayList<String> acceptedCombinations = new ArrayList<String>();
		for (int i = 0; i < combinations.size(); i++) {
			String combination = combinations.get(i);

			for (int j = 0; j < allRotatedTargetString.size(); j++) {
				if (combination.contains(allRotatedTargetString.get(j))) {
					acceptedCombinations.add(combination);
					break;
				}
			}

		}
		Collections.sort(acceptedCombinations);

		// for printing new and same line
		for (int i = 1; i <= acceptedCombinations.size(); i++) {
			if (i == acceptedCombinations.size())
				System.out.print(acceptedCombinations.get(i - 1));
			else
				System.out.println(acceptedCombinations.get(i - 1));
		}

	}

}
