package BasicProblemSolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MySolution_NextPermutation_LC31 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String[] arrInp = sc.nextLine().split(",");

		int[] inpElements = new int[arrInp.length];
		for (int i = 0; i < arrInp.length; i++) {
			inpElements[i] = Integer.parseInt(arrInp[i]);
		}

		nextPermutation(inpElements);

		sc.close();
	}

	private static void nextPermutation(int[] arrInp) {
		String compareString = "";
		ArrayList<String> sourceInp = new ArrayList<String>();
		for (int i = 0; i < arrInp.length; i++) {
			compareString += arrInp[i] + "";
			sourceInp.add(arrInp[i] + "");
		}

		ArrayList<String> nextPermutationList = new ArrayList<String>();
		getPermuatation("", sourceInp, nextPermutationList);

		arrInp = organizePermutationList(nextPermutationList, Integer.parseInt(compareString));
		// System.out.print(arrInp);
		for (int i = 0; i < arrInp.length; i++) {
			System.out.print(arrInp[i]);
		}

	}

	private static void getPermuatation(String singleCombination, ArrayList<String> rearragement,
			ArrayList<String> permutationList) {
		if (rearragement.size() == 0) {
			permutationList.add(singleCombination);
		}
		for (int i = 0; i < rearragement.size(); i++) {
			String newsingleCombination = singleCombination + rearragement.get(i);
			ArrayList<String> newRearragement = new ArrayList<String>(rearragement);
			newRearragement.remove(i);
			getPermuatation(newsingleCombination, newRearragement, permutationList);
		}

	}

	private static int[] organizePermutationList(ArrayList<String> nextPermutationList, int source) {
		String result = "";
		Collections.sort(nextPermutationList);
		for (String element : nextPermutationList) {
			if (source < Integer.parseInt(element)) {
				return getCommaSeperatedString(element);
			}
		}
		if (result.isEmpty() || result.contentEquals("")) {
			result = nextPermutationList.get(0);
			return getCommaSeperatedString(result);
		}

		return new int[] { 0 };
	}

	private static int[] getCommaSeperatedString(String element) {
		int[] result = new int[element.length()];
		for (int i = 0; i < element.length(); i++) {
			result[i] = Integer.parseInt(element.charAt(i) + "");
		}
		return result;
	}

}
