package CombinationSumFromArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC216_Combination_Sum_III {

	public static List<List<Integer>> result = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();

		combinationSum3(k, n);
		System.out.print(result);
		sc.close();
	}

	private static List<List<Integer>> combinationSum3(int k, int n) {
		List<Integer> listNum = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++) {
			listNum.add(i);
		}

		getcombinationSum3(listNum, k, n, 0, new ArrayList<Integer>());

		return result;
	}

	private static void getcombinationSum3(List<Integer> nums, int k, int n, int idx, List<Integer> path) {

		if (k == 0 && n == 0) {
			result.add(path);
			return; // backtracking
		}

		for (int i = idx; i < nums.size(); i++) {
			List<Integer> p = new ArrayList<>(path);
			p.add(nums.get(i));
			getcombinationSum3(nums, k - 1, n - nums.get(i), i + 1, p);
		}
	}

}
