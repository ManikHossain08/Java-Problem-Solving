package EditDinstanceFindMinOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MySolution1_DP_EditDistance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		System.out.print(findEditDistance(s1, s2));
		sc.close();

	}

	private static int findEditDistance(String s1, String s2) {
		
		int row = s1.length()+1;
		int col = s2.length() +1;
		
		int[][] dp = new int[row][col];

		for (int i = 0; i < row; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j < col; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				
				List<Integer> findmin = new ArrayList<Integer>();
				findmin.add(dp[i][j - 1] + 1);
				findmin.add(dp[i - 1][j] + 1);

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					findmin.add(dp[i - 1][j - 1] + 0);

				} else {
					findmin.add(dp[i - 1][j - 1] + 1);
				}

				dp[i][j] = Collections.min(findmin);
			}
		}

		return dp[row-1][col-1];
	}
}
