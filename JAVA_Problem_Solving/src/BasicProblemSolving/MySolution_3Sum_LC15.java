package BasicProblemSolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MySolution_3Sum_LC15 {
	
	public static List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int[] elements = new int[number];
		for (int i = 0; i < number; i++) {
			elements[i] = sc.nextInt();
		}

		result = find3Sum(elements);
		System.out.print(result);
		sc.close();
	}

	private static List<List<Integer>> find3Sum(int[] elements) {
		Map<String, String> temp2 = new HashMap<String, String>();

		for (int i = 0; i < elements.length; i++) {
			for (int j = i + 1; j < elements.length; j++) {
				for (int k = j + 1; k < elements.length; k++) {
					List<Integer> temp3 = new ArrayList<Integer>();
					if (elements[i] + elements[j] + elements[k] == 0) {
						temp3.add(elements[i]);
						temp3.add(elements[j]);
						temp3.add(elements[k]);
						Collections.sort(temp3);
						String value = temp3.get(0).toString() + temp3.get(1).toString() + temp3.get(2).toString();
						if (!checkDuplicateAndAdd(temp2, value)) {
							result.add(temp3);
						}
					}
				}
			}
		}

		return result;
	}

	private static boolean checkDuplicateAndAdd(Map<String, String> temp2, String value) {

		if (temp2.containsKey(value)) {
			return true;
		} else
			temp2.put(value, value);
		return false;
	}

}
