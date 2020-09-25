package ArrayOperation_LC;

import java.util.Arrays;
import java.util.Scanner;

public class KthLargestElementInArray_LC215 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.print(findKthLargest(a, k));
		sc.close();
	}

	private static int findKthLargest(int[] a, int k) {
		Arrays.sort(a);
		return a[a.length - k];
	}
}
