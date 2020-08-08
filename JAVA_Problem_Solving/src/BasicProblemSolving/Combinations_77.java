package BasicProblemSolving;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Combinations_77 {
	
	// I don't know how its solved but I just keep it
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		List<List<Integer>> result = findCombination(n, k);
		System.out.print(result);
		sc.close();
	}

	private static List<List<Integer>> findCombination(int n, int k) {
		List<List<Integer>> result = new LinkedList<>();

		if (n < k || k == 0)
			return result;

		result = findCombination(n - 1, k - 1);
		if (result.isEmpty()) {
			result.add(new LinkedList<Integer>());
		}
		// now all the list contains k - 1 elements so add n
		for (List<Integer> list : result) {
			list.add(n);
		}
		result.addAll(findCombination(n - 1, k));

		return result;
	}
}
