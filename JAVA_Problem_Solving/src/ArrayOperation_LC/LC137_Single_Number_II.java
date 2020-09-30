package ArrayOperation_LC;

import java.util.Arrays;
import java.util.Scanner;

public class LC137_Single_Number_II {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] number = sc.nextLine().split(",");
		int[] nums = new int[number.length];
		for (int i = 0; i < number.length; i++) {
			nums[i] = Integer.parseInt(number[i]);
		}

		System.out.print(singleNumber(nums));
		sc.close();
	}

	private static int singleNumber(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				continue;
			else if (nums[i] != nums[i - 1]) {
				if (i == nums.length - 1)
					return nums[i];
				else {
					i = i + 1;
					if (nums[i] == nums[i - 1])
						continue;
					else
						return nums[i-1];
				}

			}
		}
		return nums[0];
	}
}
/*
 * 
 * 0,1,0,1,0,1,99
 * 
 * 4 2 2 3 2
 * 
 * -19,-46,-19,-46,-9,-9,-19,17,17,17,-13,-13,-9,-13,-46,-28
 * 
 */
