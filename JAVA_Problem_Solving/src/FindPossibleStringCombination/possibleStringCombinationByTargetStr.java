package FindPossibleStringCombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class possibleStringCombinationByTargetStr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numLines = sc.nextInt();
		sc.nextLine(); // This removes the extra \n after first integer input.
		
		// declaration 		= initialization
		String[][] blocks2D = new String[numLines][];
		int[] numBlocksPerLine = new int[numLines];
		for (int i = 0; i < numLines; i++) {
			// Generating 2D array from here like [[a,b,c], [d,e,f]]
			blocks2D[i] = sc.nextLine().split(",");
			numBlocksPerLine[i] = blocks2D[i].length;
		}
		String targetStr = sc.nextLine();
		ArrayList<String> allRotatedTargetString = getrotatedTargetString(targetStr);

		ArrayList<String> combinations = findCombinations(blocks2D, numBlocksPerLine);
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
		for (int i = 0; i < acceptedCombinations.size(); i++) {
			if (i < acceptedCombinations.size() - 1)
				System.out.println(acceptedCombinations.get(i));
			else
				System.out.print(acceptedCombinations.get(i));
		}
		sc.close();
	}

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

	private static ArrayList<String> findCombinations(String[][] blocks2D, int[] numBlocksPerLine) {
		int numCombinations = 1;
		int numLines = numBlocksPerLine.length;
		for (int i = 0; i < numLines; i++) {
			numCombinations *= numBlocksPerLine[i];
		}
		ArrayList<String> allCombinations = new ArrayList<String>();
		int[] indices = new int[numLines];
		// next Page
		for (int i = 0; i < numCombinations; i++) {
			// Store combination blocks in an ArrayList
			ArrayList<String> combination = new ArrayList<>();
			for (int j = 0; j < numLines; j++) {
				combination.add(blocks2D[j][indices[j]]);
			}
			// Find all permutations of that combination
			ArrayList<String> permutations = new ArrayList<>();
			findPermutations("", combination, permutations);
			for (int j = 0; j < permutations.size(); j++) {
				allCombinations.add(permutations.get(j));
			}
			// Try all different choices of blocks.
			// *** Important: Must remember this piece of code to change row and column
			// value to get for combination.
			for (int j = 0; j < numLines; j++) {
				if (indices[j] < numBlocksPerLine[j] - 1) {
					indices[j]++;
					break;
				} else
					indices[j] = 0;
			}
		}
		return allCombinations;
	}
	// *** Important: remember this code for permutation that meant combination of 
	// several words and make different string
	private static void findPermutations(String selected, ArrayList<String> remaining, ArrayList<String> permutations) {
		int numRemaining = remaining.size();
		if (numRemaining == 0)
			permutations.add(selected);
		else {
			for (int i = 0; i < numRemaining; i++) {
				String newSelected = selected + remaining.get(i);
				ArrayList<String> newRemaining = new ArrayList<>(remaining);
				newRemaining.remove(i);
				findPermutations(newSelected, newRemaining, permutations);
			}
		}

	}

}
