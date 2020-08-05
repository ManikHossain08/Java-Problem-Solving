package BasicProblemSolving;

import java.util.Scanner;

public class JumpGame_Backtracking {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int elemNum = sc.nextInt();
		int[] arrInp = new int[elemNum];
		for (int i = 0; i < elemNum; i++) {
			arrInp[i] = sc.nextInt();
		}
		int position = 0;

		System.out.print(canJumpFromPosition(position, arrInp));
		sc.close();
	}

	public static boolean canJumpFromPosition(int position, int[] nums) {
		if (position == nums.length - 1) {
			return true;
		}

		int furthestJump = Math.min(position + nums[position], nums.length - 1);
		for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
			if (canJumpFromPosition(nextPosition, nums)) {
				return true;
			}
		}
		return false;
	}

}
