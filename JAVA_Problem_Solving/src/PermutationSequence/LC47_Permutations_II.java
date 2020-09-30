package PermutationSequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LC47_Permutations_II {
	public static List<List<Integer>> result = new ArrayList<List<Integer>>();
	public static Map<List<Integer>, List<Integer>> checkDuplicate = new HashMap<List<Integer>, List<Integer>>();

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
		List<String> listPermNum = new ArrayList<String>();
		for (int i = 0; i < elements.length; i++) {
			listPermNum.add(elements[i] + "");
		}
		result = getPermutationList(new ArrayList<Integer>(), listPermNum);

		return result;
	}

	private static List<List<Integer>> getPermutationList (List<Integer> singleList, List<String> newArrangement) {
		if (newArrangement.size() == 0) {
			if(!checkDuplicate.containsKey(singleList)) { // adding after checking duplicate.... 
				result.add(singleList);
				checkDuplicate.put(singleList, singleList);
			}
			return result;
		}
		for (int index = 0; index < newArrangement.size(); index++) {

			List<Integer> newResultList = new ArrayList<Integer>(singleList);
			int value = Integer.parseInt(newArrangement.get(index));
			newResultList.add(value);

			List<String> newNumbers = new ArrayList<String>(newArrangement);
			newNumbers.remove(index);
			getPermutationList(newResultList, newNumbers);

		}
		return result;
	}
}
