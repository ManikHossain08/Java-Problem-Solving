package BasicProblemSolving;

import java.util.Scanner;

public class MySolution_MostWaterInContaiiner_LC11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int eleNum = sc.nextInt();
		int[] inputs = new int[eleNum];
		for (int i = 0; i < eleNum; i++) {
			inputs[i] = sc.nextInt();
		}
		System.out.print(maxArea1(inputs));
		System.out.print(maxArea2(inputs));
		sc.close();
	}

	// SOLUTION-1: 2 FOR LOOPS WITH INCREMENTS AND DECREMENTS
	private static int maxArea1(int[] height) {
		int max = 0;

		for (int i = 0; i < height.length; i++) {
			for (int j = height.length - 1; j > i; j--) {
				int area = Math.min(height[i], height[j]) * (j - i);
				max = Math.max(max, area);
			}
			// int[] nums = Arrays.copyOfRange(height, i, height.length);
			// int min = Arrays.stream(nums).min().getAsInt();
		}
		return max;
	}

	// SOLUTION-1: 2 FOR LOOPS WITH ONLY INCREMENTS
	private static int maxArea2(int[] height) {
		int maxarea = 0;
		for (int i = 0; i < height.length; i++)
			for (int j = i + 1; j < height.length; j++)
				maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
		return maxarea;
	}

}
