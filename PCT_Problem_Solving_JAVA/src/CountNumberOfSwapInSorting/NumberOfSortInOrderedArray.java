package CountNumberOfSwapInSorting;

import java.util.Scanner;

public class NumberOfSortInOrderedArray {
	public static void main(String args[]) {
		
		Scanner in_sc = new Scanner(System.in);
		int inputNum = in_sc.nextInt();
		int[] inpArray = new int[inputNum];
		
		for (int i = 0; i < inputNum; i++) {
			inpArray[i] = in_sc.nextInt();
			in_sc.nextLine();
		}

		int swap = 0;
		int swapCount = 0;

		for (int i = 0; i < inputNum; i++) {
			for (int j = i + 1; j < inputNum; j++) {
				if (inpArray[i] > inpArray[j]) {
					swap = inpArray[i];
					inpArray[i] = inpArray[j];
					inpArray[j] = swap;
					swapCount++;
				}
			}
		}
		
		System.out.print(swapCount);
		in_sc.close();
	}

}

