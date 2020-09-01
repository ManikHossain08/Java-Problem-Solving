package BasicProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NextPermutation {
	// THIS IS NOT THE ACCEPTED SOLUTION FOR LEETCODE BECAUSE 213 / 265 test cases passed.
	// inp = 4,2,0,2,3,2,0
	// out = 4,2,0,3,0,2,2
	// this inp, output did not worked.

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int inpNum = sc.nextInt();
		int[] arrInp = new int[inpNum];
		for (int i = 0; i < inpNum; i++) {
			arrInp[i] = sc.nextInt();
		}

		findNextPermutation(arrInp);
		for (int i = 0; i < arrInp.length; i++) {
			if (i == arrInp.length - 1)
				System.out.print(arrInp[i]);
			else
				System.out.print(arrInp[i] + ",");
		}

		sc.close();
	}

	private static void findNextPermutation(int[] arrInp) {
		int start = 0, end = 0, counter = 0;
		for (int i = arrInp.length - 1; i > 0; i--) {
			if (counter > 0)
				break;
			for (int j = i - 1; j >= 0; j--) {
				if (arrInp[i] > arrInp[j]) {
					int swap = arrInp[i];
					arrInp[i] = arrInp[j];
					arrInp[j] = swap;
					counter++;
					start = j + 1;
					end = arrInp.length;
					break;
				}
				if (counter > 0)
					break;
			}
		}
		if (counter == 0) {
			Arrays.sort(arrInp);
		} else {
			reverseArray(arrInp, start, end);
		}
	}

	private static void reverseArray(int[] arrInp, int start, int end) {
		int[] reverseArr = Arrays.copyOfRange(arrInp, start, end);
		List<Integer> revList = new ArrayList<Integer>();
		for (int i = 0; i < reverseArr.length; i++) {
			revList.add(reverseArr[i]);
		}
		Collections.reverse(revList);

		int index = 0;
		for (int i = start; i < end; i++) {
			arrInp[i] = (revList.get(index));
			index++;
		}

	}
}



