package ArrayOperation_LC;

import java.util.Scanner;

public class LC162_Find_Peak_Element {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();

		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = sc.nextInt();
		}

		System.out.print(findPeakElement(nums));
		sc.close();

	}

	private static int findPeakElement(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1])
				return i;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1] && i == nums.length - 2)
				return i + 1;
		}
		return 0;
	}
}

/*
 * 7 
 * 1 2 1 3 5 6 4
 */