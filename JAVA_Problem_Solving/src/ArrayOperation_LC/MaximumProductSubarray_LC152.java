package ArrayOperation_LC;

import java.util.Scanner;

public class MaximumProductSubarray_LC152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.print(maxProduct(arr));
		sc.close();
	}

	private static int maxProduct(int[] a) {
		if (a == null || a.length == 0)
		    return 0;

		  int ans = a[0], min = ans, max = ans;
		  
		  for (int i = 1; i < a.length; i++) {
		    if (a[i] >= 0) {
		      max = Math.max(a[i], max * a[i]);
		      min = Math.min(a[i], min * a[i]);
		    } else {
		      int tmp = max;
		      max = Math.max(a[i], min * a[i]);
		      min = Math.min(a[i], tmp * a[i]);
		    }
		    
		    ans = Math.max(ans, max);
		  }
		  
		  return ans;
	}
}
// [-2,3,-4] = 24