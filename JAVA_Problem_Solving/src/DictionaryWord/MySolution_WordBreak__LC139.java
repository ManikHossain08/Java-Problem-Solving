package DictionaryWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MySolution_WordBreak__LC139 {
	// https://leetcode.com/problems/combination-sum/
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String targetstr = sc.nextLine();
		String[] words = sc.nextLine().split(",");
		List<String> wordList = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			wordList.add(words[i]);
		}

		//System.out.print(findWordBreakCOmbination(targetstr ,wordList));
		sc.close();
	}
	
//	private static List<List<Integer>> findWordBreakCOmbination(String str, List<String> words) {
//		Collections.sort(words);
//		List<List<Integer>> result = new ArrayList<>();
//		// Note: purpose of using this first for loop is the the number should be repeat as much as many times.
//		for (int i = 0; i < words.size(); i++) {
//			combinationSumSorted(words, i, str - words[i], List.of(words[i]), result);
//		}
//		return result;
//	}
//
//	private static void combinationSumSorted(int[] candidates, int start, int target, List<Integer> curr,
//			List<List<Integer>> result) {
//		if (target == 0) {
//			result.add(curr);
//		}
//		for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
//			List<Integer> newCurr = new ArrayList<>(curr);
//			newCurr.add(candidates[i]);
//			combinationSumSorted(candidates, i, target - candidates[i], newCurr, result);
//		}
//	}

}
