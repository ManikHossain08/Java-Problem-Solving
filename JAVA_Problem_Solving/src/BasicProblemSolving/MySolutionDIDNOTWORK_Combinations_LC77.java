package BasicProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySolutionDIDNOTWORK_Combinations_LC77 {
	public static List<List<Integer>> result = new ArrayList<List<Integer>>();
	public static int n, k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		System.out.print(findCombinations(n, k));
		sc.close();
	}

	private static List<List<Integer>> findCombinations(int n, int k) {
		// TODO Auto-generated method stub

		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		List<Integer> list = new ArrayList<Integer>();
		return combinations(numbers, 0, 0, list);
	}

	private static List<List<Integer>> combinations(int[] numbers, int nn, int kk, List<Integer> list) {
		if (kk == k) {
			result.add(list);
			list = new ArrayList<Integer>();
			return null;
		}

		for (int i = nn + 1; i < numbers.length; i++) {
			list.add(numbers[i]);
			combinations(numbers, nn + 1, kk + 1, list);
		}

		return result;
	}
}
