package ArrayOperation_LC;

import java.util.Arrays;
import java.util.Scanner;

public class LC275_H_Index_II {
	
	/*
	 * Based on the question:

		max value of citation is the length of the citations.
		assign k = length of citations array.
		iterate from left to right.
		if the leftmost element is greater than or equal to k -> there are k elements with values at least k. 
		(so return k);
		else decrease k(because of excluding one element) and go to next element and repeat the same.
	 */
	
	/*
	 * IF WE COMMENT THIS LINE 'Arrays.sort(citations);' THIS WILL SOLVE ONLY PROBLEM 
	 * LC_275 
	 * BUT WE UNCOMMENT THIS LINE 'Arrays.sort(citations);' THIS WILL SOLVE BOTH PROBLEM LC_274 AND
	 * LC_275
	 */
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();

		int[] citations = new int[size];
		for (int i = 0; i < size; i++) {
			citations[i] = sc.nextInt();
		}

		System.out.print(hIndex(citations));
		sc.close();

	}

	public static int hIndex(int[] citations) {
		int k = citations.length;
		Arrays.sort(citations);
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= k)
				return k;
			else {
				k--;
			}
		}

		return k;
	}
}
