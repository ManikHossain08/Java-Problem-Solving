package CombinationSumFromArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySolution_CombinationSum_LC40 {
	
	// https://leetcode.com/problems/combination-sum/
	public static int [] arrInp;
	public static int orgTarget;
	public static List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int inNum = sc.nextInt();
		arrInp = new int[inNum];
		for (int i = 0; i < inNum; i++) {
			arrInp[i] = sc.nextInt();
		}
		orgTarget = sc.nextInt();

		System.out.print(findSumCOmbination(arrInp, orgTarget));
		sc.close();
	}
	
	private static List<List<Integer>> findSumCOmbination(int[] candidates, int target) {
		//Arrays.sort(arrInp); 
		// Note: purpose for using this first for loop is the the number should be repeat as much as many times
		// until the target.
		arrInp = candidates;
		for (int i = 0; i < arrInp.length; i++) {
			result = combinationSumSorted(i, arrInp[i], List.of(arrInp[i]));
		}
		return result;
	}

	private static List<List<Integer>>  combinationSumSorted(int startIdx, int target, List<Integer> numbers) {
		
		if (target > orgTarget) return result;
		
		if (target == orgTarget) {
			result.add(numbers);
		}
		
		// this piece of code is same as the combination of the code 
		for (int i = startIdx; i < arrInp.length; i++) {
			List<Integer> newNumbers = new ArrayList<>(numbers);
			newNumbers.add(arrInp[i]);
			combinationSumSorted(i, target + arrInp[i], newNumbers);
		}
		return result;
	}

}
