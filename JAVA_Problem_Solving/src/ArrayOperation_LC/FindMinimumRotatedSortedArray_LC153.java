package ArrayOperation_LC;

import java.util.Scanner;

public class FindMinimumRotatedSortedArray_LC153 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}

		System.out.print(findMinimumRotatedSortedArray(a));
		sc.close();
	}

	private static int findMinimumRotatedSortedArray(int[] a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			min = Math.min(min, a[i]);
		}
		return min;
	}
}
