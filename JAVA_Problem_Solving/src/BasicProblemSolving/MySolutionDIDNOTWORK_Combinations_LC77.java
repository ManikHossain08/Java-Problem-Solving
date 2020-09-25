package BasicProblemSolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MySolutionDIDNOTWORK_Combinations_LC77 {
	public static Map<List<Integer>, List<Integer>> result = new HashMap<List<Integer>, List<Integer>>();
	public static int n, k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		System.out.print(findCombinations(n, k));
		sc.close();
	}

	private static List<List<Integer>> findCombinations(int nn, int kk) {
		n = nn; k = kk;
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		List<Integer> list = new ArrayList<Integer>();
		
		Map<List<Integer>, List<Integer>> newresult = combinations(numbers, 0, 0, list);
		List<List<Integer>> resultSet = new ArrayList<List<Integer>>();
		for (List<Integer> listVal : newresult.values()) {
			resultSet.add(listVal);
		}
		
		return resultSet;
	}

	private static Map<List<Integer>, List<Integer>> combinations(int[] numbers, int nn, int kk, List<Integer> list) {
		if (kk == k) {
			
			List<Integer> rSet = new ArrayList<Integer>(list);
			Collections.sort(list);
			if (!result.containsKey(list) && !isAllSame(list)) {
				result.put(rSet, rSet);
			}
			
			return null;
		}

		for (int i = nn; i < numbers.length; i++) {

			List<Integer> newList = new ArrayList<>(list);
			newList.add(numbers[i]);
			combinations(numbers, nn + 1, kk + 1, newList);
			newList.remove(newList.size() - 1);
		}

		return result;
	}

	private static boolean isAllSame(List<Integer> list) {
		
		for (int i = 1; i < list.size(); i++) {
			if(list.get(0) != list.get(i)) 
				return false;
		}
		if(k==1) return false;
		else return true;
	}
}
