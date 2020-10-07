package ArrayOperation_LC;

public class findMaxAverage_LC643 {

	public static void main(String[] args) {
		int[] arr = { 1, 12, -5, -6, 50, 3 };
		int k = 4;

		System.out.print(findMaxAverage(arr, k));
	}

	public static double findMaxAverage(int[] nums, int k) {
		long sum = 0;
		for (int i = 0; i < k; i++)
			sum += nums[i];
		long max = sum;

		int left = 0; 
		for (int i = k; i < nums.length; i++) {
			sum += nums[i] - nums[left++];
			max = Math.max(max, sum);
		}

		return max / 1.0 / k;
	}
}
