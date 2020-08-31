package PermutationSequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySolution_PermutationSequence_LC60 {
	// this code recover from TLE and accepted on leetcode
	
	public static List<String> result = new ArrayList<String>();
	public static int counter = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		System.out.print(getPermutationSequence(n, k));
		sc.close();
	}

	private static String getPermutationSequence(int n, int k) {

		List<String> numList = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			numList.add(i + "");
		}

		getPermutationSequence("", numList, k);

		return result.get(k-1);
	}

	private static List<String> getPermutationSequence(String singleOrder, List<String> newNumList, int k) {

		if (newNumList.size() == 0) {
			result.add(singleOrder);
			counter++;
			return result;
		}
		if(counter == k) return result;
		for (int i = 0; i < newNumList.size(); i++) {
			String sequence = singleOrder + newNumList.get(i);
			List<String> numList = new ArrayList<String>(newNumList);
			numList.remove(i);
			getPermutationSequence(sequence, numList, k);
		}

		return result;
	}
}
