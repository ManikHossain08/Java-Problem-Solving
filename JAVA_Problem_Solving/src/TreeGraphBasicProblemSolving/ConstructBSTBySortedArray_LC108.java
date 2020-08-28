package TreeGraphBasicProblemSolving;

import java.util.Scanner;

public class ConstructBSTBySortedArray_LC108 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] elements = sc.nextLine().split(",");
		int[] inputs = new int[elements.length];
		for (int i = 0; i < elements.length; i++) {
			inputs[i] = Integer.parseInt(elements[i]);
		}
		TreeNode tree = sortedArrayToBST(inputs);
		System.out.print(tree);
		sc.close();
	}

	private static TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0 || nums == null)
			return null;

		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {

		if (start > end)
			return null;

		int middle = (start + end) / 2;
		TreeNode tree = new TreeNode(nums[middle]);

		tree.left = sortedArrayToBST(nums, start, middle - 1);
		tree.right = sortedArrayToBST(nums, middle + 1, end);

		return tree;
	}
}
