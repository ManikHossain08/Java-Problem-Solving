package CombinationSumFromArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MySolution_DistinctCombinationSum {
	public static int [] Allcandidates;
	public static int orgTarget;
	public static List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		orgTarget = scan.nextInt();
		int numofElement = scan.nextInt();
		Allcandidates = new int[numofElement];
		for (int i = 0; i < numofElement; i++) {
			Allcandidates[i] = scan.nextInt();
		}
		List<List<Integer>> distinctCount = combinationSum2(Allcandidates, orgTarget);

		//System.out.println(distinctCount.size());
		System.out.println(distinctCount);

		scan.close();

	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(Allcandidates); // for distinct sorting the array is mandatory
	
		// no need to use loop here because DO NOT WANT repetition of the same number again and again.
		// like other problem in the same package from leetcode_39
		combinationSumHelper(0, 0, new ArrayList<Integer>());
		return result;
	}

	public static List<List<Integer>> combinationSumHelper(int startIdx, int target, List<Integer> number) {
		
		if (target > orgTarget) return null; 
		
		if (target == orgTarget) {
			result.add(number);
		}
		for (int i = startIdx; i < Allcandidates.length; i++) {
			
			if (i > startIdx && Allcandidates[i] == Allcandidates[i - 1]) continue; // skip duplicates
			
			List<Integer> newNumbers = new ArrayList<>(number);
			newNumbers.add(Allcandidates[i]);
			combinationSumHelper(i + 1, target + Allcandidates[i], newNumbers);
		}
	return result;
	}

}
