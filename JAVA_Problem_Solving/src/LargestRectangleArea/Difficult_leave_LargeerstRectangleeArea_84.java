package LargestRectangleArea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Difficult_leave_LargeerstRectangleeArea_84 {
	// its very very difficult to understand so Leave it
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int inputNo = sc.nextInt();
		int[] heightOfRectangle = new int[inputNo];
		for (int i = 0; i < inputNo; i++) {
			heightOfRectangle[i] = sc.nextInt();
		}

		System.out.print(findLargestRectangularArea(heightOfRectangle));
		sc.close();

	}

	private static int findLargestRectangularArea(int[] heights) {
	
		if (heights.length == 0)
			return 0;

		int[] firstSmallerOntheLeft = new int[heights.length];
		int[] firstSmallerOntheRight = new int[heights.length];

		Arrays.fill(firstSmallerOntheLeft, -1);
		Arrays.fill(firstSmallerOntheRight, heights.length);

		Stack<Integer> stack = new Stack<Integer>();
		

		for (int i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
				firstSmallerOntheRight[stack.pop()] = i;
			}
			if (!stack.isEmpty())
				firstSmallerOntheLeft[i] = stack.peek();
			
			stack.push(i);
		}

		int res = 0;

		for (int i = 0; i < heights.length; i++) {

			int l = firstSmallerOntheLeft[i];
			int r = firstSmallerOntheRight[i];
			res = Math.max(res, (r - l - 1) * heights[i]);
			
		}

		return res;
	}

}
