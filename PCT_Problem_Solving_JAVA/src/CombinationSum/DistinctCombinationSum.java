package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DistinctCombinationSum {
	public static void main(String args[]) {
		//**** source of Code: https://gist.github.com/wayetan/8215995
		
		Scanner scan = new Scanner(System.in);
		int targetSum = scan.nextInt();
		int numofElement = scan.nextInt();
		int[] Allcandidates = new int[numofElement];
		for (int i = 0; i < numofElement; i++) {
			Allcandidates[i] = scan.nextInt();
		}
		ArrayList<ArrayList<Integer>> distinctCount = combinationSum2(Allcandidates, targetSum);
		
		System.out.println(distinctCount.size());

		scan.close();

	}

	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(candidates);
		combinationSumHelper(candidates, 0, target, new ArrayList<Integer>(), res);
		return res;
	}

	public static void combinationSumHelper(int[] candidates, int start, int target, ArrayList<Integer> path,
			ArrayList<ArrayList<Integer>> res) {
		if (start < 0 || target < 0)
			return;
		if (target == 0) {
			ArrayList<Integer> result = new ArrayList<Integer>(path);
			res.add(result);
		} else {
			for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
				// skip duplicates
				if (i > start && candidates[i] == candidates[i - 1])
					continue;
				path.add(candidates[i]);
				combinationSumHelper(candidates, i + 1, target - candidates[i], path, res);
				path.remove(path.size() - 1);
			}
		}
	}

}
