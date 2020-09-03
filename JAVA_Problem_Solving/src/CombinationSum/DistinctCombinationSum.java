package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DistinctCombinationSum {
	public static int [] Allcandidates;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int targetSum = scan.nextInt();
		int numofElement = scan.nextInt();
		Allcandidates = new int[numofElement];
		for (int i = 0; i < numofElement; i++) {
			Allcandidates[i] = scan.nextInt();
		}
		ArrayList<List<Integer>> distinctCount = combinationSum2(Allcandidates, targetSum);

		//System.out.println(distinctCount.size());
		System.out.println(distinctCount);

		scan.close();

	}

	public static ArrayList<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(Allcandidates);
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		// no need to use loop here because do not want repetition of the same number again and again.
		// like other problem in the same package from leetcode_39
		combinationSumHelper(0, target, new ArrayList<Integer>(), res);
		return res;
	}

	public static void combinationSumHelper(int startIdx, int target, List<Integer> curr,
			List<List<Integer>> res) {
		
		if (target == 0) {
			res.add(curr);
			return;
		}
		for (int i = startIdx; i < Allcandidates.length && Allcandidates[i] <= target; i++) {
			
			if (i > startIdx && Allcandidates[i] == Allcandidates[i - 1]) continue; // skip duplicates
			
			List<Integer> newCurr = new ArrayList<>(curr);
			newCurr.add(Allcandidates[i]);
			combinationSumHelper(i + 1, target - Allcandidates[i], newCurr, res);
		}

	}

}
