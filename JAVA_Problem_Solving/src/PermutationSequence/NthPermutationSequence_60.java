package PermutationSequence;

import java.util.ArrayList;
import java.util.Scanner;

public class NthPermutationSequence_60 {

	// this piece of code must be memorize for exam otherwise you will miss lots of
	// things
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.print(findPermutationSequence(n, k));
		sc.close();
	}

	private static String findPermutationSequence(int n, int k) {

		ArrayList<String> inputs = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			inputs.add(i + "");
		}
		ArrayList<String> permutation = new ArrayList<String>();
		String select = "";
		getPermutationSequence(select, inputs, permutation);

		return permutation.get(k - 1);
	}

	private static void getPermutationSequence(String singleCombination, ArrayList<String> rearragement,
			ArrayList<String> permutationList) {
		if (rearragement.size() == 0) {
			permutationList.add(singleCombination);
		}
		for (int i = 0; i < rearragement.size(); i++) {
			String newsingleCombination = singleCombination + rearragement.get(i);
			ArrayList<String> newRearragement = new ArrayList<String>(rearragement);
			newRearragement.remove(i);
			getPermutationSequence(newsingleCombination, newRearragement, permutationList);
		}

	}
}
