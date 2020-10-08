package ArrayOperation_LC;

import java.util.HashSet;
import java.util.Set;

public class LC128_Longest_Consecutive_Sequence {

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.print(longestConsecutive(nums));
		System.out.print(longestConsecutive_2(nums));

	}
	// slower code: 692 ms
	private static int longestConsecutive(int[] nums) {
		Set<Integer> hs = new HashSet<Integer>();
		int maxConsec = 0;
		int countConsec = 0;
		for (int i = 0; i < nums.length; i++) {
			hs.add(nums[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			countConsec = 1;
			for (int j = 0; j < nums.length; j++) {
				if (hs.contains(nums[i] + j + 1))
					countConsec++;
				else
					break;
			}
			maxConsec = Math.max(maxConsec, countConsec);
		}

		return maxConsec;
	}

	// faster code: 4 ms
	public static int longestConsecutive_2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Set<Integer> set = new HashSet<>(), visited = new HashSet<>();
		for (int i : nums)
			set.add(i);

		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			if (visited.contains(nums[i]))
				continue;
			else {
				int left = nums[i], right = nums[i];
				while (set.contains(left)) {
					visited.add(left);
					left--;
				}
				while (set.contains(right)) {
					visited.add(right);
					right++;
				}
				max = Math.max(max, right - left - 1);
			}
		}

		return max;
	}

}
