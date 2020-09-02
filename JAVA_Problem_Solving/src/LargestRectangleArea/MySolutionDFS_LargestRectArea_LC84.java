package LargestRectangleArea;

import java.util.Scanner;

public class MySolutionDFS_LargestRectArea_LC84 {
	// Solution (Divide and Conquer)
	// easy to understand
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int elementsno = sc.nextInt();
		int[] height = new int[elementsno];

		for (int i = 0; i < elementsno; i++) {
			height[i] = sc.nextInt();
		}

		System.out.print(maxRectArea(height));
		sc.close();
	}

	private static int maxRectArea(int[] height) {

		return helper(height, 0, height.length - 1);
	}

	private static int helper(int[] height, int leftIdx, int rightIdx) {

		if (leftIdx == rightIdx)
			return height[leftIdx];
		if (leftIdx > rightIdx)
			return 0;
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for (int i = leftIdx; i <= rightIdx; i++) {
			if (height[i] < min) {
				min = height[i];
				minIndex = i;
			}
		}

		int maxRectArea = (Math.abs(leftIdx - rightIdx) + 1) * min;
		int leftArea = helper(height, leftIdx, minIndex - 1);
		int rightArea = helper(height, minIndex + 1, rightIdx);

		return Math.max(maxRectArea, Math.max(leftArea, rightArea));
	}
}

// 6
// 2 1 5 6 2 3
