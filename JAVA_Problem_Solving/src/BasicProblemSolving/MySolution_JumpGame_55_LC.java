package BasicProblemSolving;

import java.util.Scanner;

public class MySolution_JumpGame_55_LC {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int elements = sc.nextInt();
		int[] arrInp = new int[elements];
		for (int i = 0; i < elements; i++) {
			arrInp[i] = sc.nextInt();
		}

		System.out.print(canJump(arrInp));
		sc.close();
	}

	private static boolean canJump(int[] nums) {

		return canjumpFurther(0, nums);
	}

	private static boolean canjumpFurther(int position, int[] nums) {
		if (nums == null || nums.length == 0)
			return true;
		if (position == nums.length - 1)
			return true;

		// int jumpLength = Math.min(nums[position] + position, nums.length - 1);
		int jumpLength = nums[position] + position;

		for (int nextPosition = position + 1; nextPosition <= jumpLength
				&& nextPosition <= nums.length - 1; nextPosition++) {
			if (canjumpFurther(nextPosition, nums))
				return true;
		}

		return false;
	}
}
