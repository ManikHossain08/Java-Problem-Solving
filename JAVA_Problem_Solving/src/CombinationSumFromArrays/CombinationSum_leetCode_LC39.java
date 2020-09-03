package CombinationSumFromArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSum_leetCode_LC39 {
	// https://leetcode.com/problems/combination-sum/
	public static int [] arrInp;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int inNum = sc.nextInt();
		arrInp = new int[inNum];
		for (int i = 0; i < inNum; i++) {
			arrInp[i] = sc.nextInt();
		}
		int target = sc.nextInt();

		System.out.print(findSumCOmbination(arrInp, target));
		sc.close();
	}
	
	private static List<List<Integer>> findSumCOmbination(int[] candidates, int target) {
		Arrays.sort(arrInp);
		List<List<Integer>> result = new ArrayList<>();
		// Note: purpose for using this first for loop is the the number should be repeat as much as many times
		// until the target.
		for (int i = 0; i < arrInp.length; i++) {
			combinationSumSorted(i, target - arrInp[i], List.of(arrInp[i]), result);
		}
		return result;
	}

	private static void combinationSumSorted(int startIdx, int target, List<Integer> numbers,
			List<List<Integer>> result) {
		if (target == 0) {
			result.add(numbers);
		}
		// this piece of code is same as the combination of the code 
		for (int i = startIdx; i < arrInp.length && arrInp[i] <= target; i++) {
			List<Integer> newNumbers = new ArrayList<>(numbers);
			newNumbers.add(arrInp[i]);
			combinationSumSorted(i, target - arrInp[i], newNumbers, result);
		}
	}

}
