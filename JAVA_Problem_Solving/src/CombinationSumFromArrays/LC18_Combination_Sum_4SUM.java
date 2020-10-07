package CombinationSumFromArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LC18_Combination_Sum_4SUM {

	public static List<List<Integer>> result = new ArrayList<List<Integer>>();
	public static Set<List<Integer>> checkDup = new HashSet<List<Integer>>();
	// 218 / 283 test cases passed.
	// got: TLE, so NOT ACCECPTED ON LEETCODE
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int k = sc.nextInt();
		//int n = sc.nextInt();
		//int[] nums = {1,0,-1,0,-2,2};
		int[] nums = {-2,-1,-1,1,1,2,2};
		int target = sc.nextInt();
		combination_fourSum(nums, target);
		System.out.print(result);
		sc.close();
	}

	private static List<List<Integer>> combination_fourSum(int[] nums, int target) {
		List<Integer> listNum = new ArrayList<Integer>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			listNum.add(nums[i]);
		}

		getcombinationFourSum(listNum, 4, target, 0, new ArrayList<Integer>());

		return result;
	}

	private static void getcombinationFourSum(List<Integer> nums, int k, int n, int idx, List<Integer> path) {

		if (k == 0 && n == 0 ) {
			//Collections.sort(path);
			if(!checkDup.contains(path)) {
				result.add(path);
				checkDup.add(path);
			}
			return; // backtracking
		}

		for (int i = idx; i < nums.size(); i++) {
			List<Integer> p = new ArrayList<>(path);
			p.add(nums.get(i));
			getcombinationFourSum(nums, k - 1, n - nums.get(i), i + 1, p);
		}
	}

}
