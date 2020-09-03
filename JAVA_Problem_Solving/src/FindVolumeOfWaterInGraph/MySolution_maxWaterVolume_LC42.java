package FindVolumeOfWaterInGraph;

import java.util.Arrays;
import java.util.Scanner;

public class MySolution_maxWaterVolume_LC42 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs = sc.nextLine().split(",");
		
		int[] heights = new int[inputs.length];
		for (int i = 0; i < heights.length; i++) {
			heights[i] = Integer.parseInt(inputs[i]);
		}

		System.out.print(calcVolumeOfWater(heights));
		sc.close();
	}

	private static int calcVolumeOfWater(int[] heights) {
		int maxArea = 0;
		for (int i = 1; i < heights.length; i++) {
			int middle = heights[i];
			int leftMax = calcVolumeOfWater(heights, 0, i);
			int rightMax = calcVolumeOfWater(heights, i + 1, heights.length);
			int minOfMaxs = Math.min(leftMax, rightMax);
			int curPositionVal = minOfMaxs - middle;
			maxArea += curPositionVal > 0 ? curPositionVal : 0;
		}
		return maxArea;
	}

	private static int calcVolumeOfWater(int[] heights, int left, int right) {
		int max = 0;
		int[] subcopy = Arrays.copyOfRange(heights, left, right);
		if(subcopy.length != 0)
		 max = Arrays.stream(subcopy).max().getAsInt();
		return max;
	}
}
