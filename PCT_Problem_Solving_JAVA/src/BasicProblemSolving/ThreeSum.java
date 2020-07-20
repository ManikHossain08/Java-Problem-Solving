package BasicProblemSolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arrInput = new int[num];
		for (int i = 0; i < num; i++) {
			arrInput[i] = sc.nextInt();
		}
		List<List<Integer>> output = find3SumSolution(arrInput);
		System.out.print(output);
		sc.close();

	}

	private static List<List<Integer>> find3SumSolution(int[] arrInput) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		boolean isDup = false;
		String left = "", right = "";
		for (int i = 0; i < arrInput.length; i++) {
			for (int j = i + 1; j < arrInput.length; j++) {
				for (int k = j + 1; k < arrInput.length; k++) {
					ArrayList<Integer> list1 = new ArrayList<Integer>();

					if ((arrInput[i] + arrInput[j] + arrInput[k]) == 0) {
						list1.add(arrInput[i]);
						list1.add(arrInput[j]);
						list1.add(arrInput[k]);
						Collections.sort(list1);
						left = list1.get(0).toString() + list1.get(1).toString() + 
								list1.get(2).toString();

						for (int l = 0; l < res.size(); l++) {
							List<Integer> listelement = res.get(l);
							Collections.sort(listelement);
							isDup = false;
							right = listelement.get(0).toString() + listelement.get(1).toString() + 
									listelement.get(2).toString();
							if (left.strip().equals(right.strip())) {
								isDup = true;
								break;

							} else {
								isDup = false;
							}
						}

						if (!isDup) {
							res.add(list1);
							isDup = false;
						}

					}
				}
			}

		}
		return res;
	}

}
