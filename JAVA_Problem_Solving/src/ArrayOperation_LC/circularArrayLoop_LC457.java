package ArrayOperation_LC;

public class circularArrayLoop_LC457 {
	public static void main(String[] args) {
		int[] arr = { 2, -1, 1, 2, 2 };

		System.out.print(circularArrayLoop(arr));
	}

	public static boolean circularArrayLoop(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			if (isCycle(nums, i, nums[i] > 0))
				return true;
		return false;
	}

	// detect cycle in directed graph going in one direction
	private static boolean isCycle(int[] nums, int i, boolean isPos) {
		if (nums[i] == 0)
			return true;
		if ((nums[i] > 0) != isPos)
			return false;
		int n = nums.length, next = (n + (i + nums[i]) % n) % n;
		if (next == i)
			return false;
		int backup = nums[i];
		nums[i] = 0;
		if (isCycle(nums, next, isPos))
			return true;
		nums[i] = backup;
		return false;
	}
}
