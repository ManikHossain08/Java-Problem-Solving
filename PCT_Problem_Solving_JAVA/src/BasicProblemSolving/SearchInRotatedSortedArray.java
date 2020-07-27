package BasicProblemSolving;

import java.util.Scanner;

public class SearchInRotatedSortedArray {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int inpNum = sc.nextInt();
		int[] arrInp = new int[inpNum];
		for (int i = 0; i < inpNum; i++) {
			arrInp[i] = sc.nextInt();
		}
		int target = sc.nextInt();

		System.out.print(search(arrInp, target));
		sc.close();

	}

	private static int search(int[] nums, int target) {
		int flag = 0;
		if (nums.length == 0)
			return -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				flag = i;
				break;
			} else
				flag = -1;
		}
		return flag;
	}
}
