package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DistinctCombinationSum {
	public static void main(String args[]) {
		// **** source of Code: https://gist.github.com/wayetan/8215995
		// NOTE: did not understand properly
		Scanner scan = new Scanner(System.in);
		int targetSum = scan.nextInt();
		int numofElement = scan.nextInt();
		int[] Allcandidates = new int[numofElement];
		for (int i = 0; i < numofElement; i++) {
			Allcandidates[i] = scan.nextInt();
		}
		ArrayList<List<Integer>> distinctCount = combinationSum2(Allcandidates, targetSum);

		System.out.println(distinctCount.size());
		System.out.println(distinctCount);

		scan.close();

	}

	public static ArrayList<List<Integer>> combinationSum2(int[] candidates, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		combinationSumHelper(candidates, 0, target, new ArrayList<Integer>(), res);
		return res;
	}

	public static void combinationSumHelper(int[] candidates, int start, int target, List<Integer> curr,
			List<List<Integer>> res) {
		if (start < 0 || target < 0)
			return;
		if (target == 0) {
			res.add(curr);
			return;
		}
		for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
			// skip duplicates
			if (i > start && candidates[i] == candidates[i - 1])
				continue;
			List<Integer> newCurr = new ArrayList<>(curr);
			newCurr.add(candidates[i]);
			combinationSumHelper(candidates, i + 1, target - candidates[i], newCurr, res);
		}

	}

}
