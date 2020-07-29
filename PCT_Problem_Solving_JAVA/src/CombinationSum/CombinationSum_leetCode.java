package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSum_leetCode {
	// https://leetcode.com/problems/combination-sum/
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int inNum = sc.nextInt();
		int[] arrInp = new int[inNum];
		for (int i = 0; i < inNum; i++) {
			arrInp[i] = sc.nextInt();
		}
		int target = sc.nextInt();

		System.out.print(findSumCOmbination(arrInp, target));
		sc.close();
	}

	private static List<List<Integer>> findSumCOmbination(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < candidates.length; i++) {
			combinationSumSorted(candidates, i, target - candidates[i], List.of(candidates[i]), result);
		}
		return result;
	}

	private static void combinationSumSorted(int[] candidates, int start, int target, List<Integer> curr,
			List<List<Integer>> result) {
		if (target == 0) {
			result.add(curr);
		}
		for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
			List<Integer> newCurr = new ArrayList<>(curr);
			newCurr.add(candidates[i]);
			combinationSumSorted(candidates, i, target - candidates[i], newCurr, result);
		}
	}

}
