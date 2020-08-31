package PermutationSequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySolution_Permutations_LC46 {
	public static List<List<Integer>> result = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums = sc.nextInt();
		int[] elements = new int[nums];

		for (int i = 0; i < nums; i++) {
			elements[i] = sc.nextInt();
		}

		permute(elements);
		System.out.print(result);
		sc.close();
	}

	private static List<List<Integer>> permute(int[] elements) {
		List<String> perNum = new ArrayList<String>();
		for (int i = 0; i < elements.length; i++) {
			perNum.add(elements[i] + "");
		}

		result = getPermutationList(new ArrayList<Integer>(), perNum);

		return result;
	}

	private static List<List<Integer>> getPermutationList (List<Integer> singleList, List<String> newArrangement) {
		if (newArrangement.size() == 0) {
			result.add(singleList);
			return result;
		}
		for (int i = 0; i < newArrangement.size(); i++) {

			List<Integer> newlist = new ArrayList<Integer>(singleList);
			int value = Integer.parseInt(newArrangement.get(i));
			newlist.add(value);

			List<String> newNumbers = new ArrayList<String>(newArrangement);
			newNumbers.remove(i);
			getPermutationList(newlist, newNumbers);

		}
		return result;
	}
}
