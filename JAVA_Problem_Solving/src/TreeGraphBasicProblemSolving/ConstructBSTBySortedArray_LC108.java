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
		if(nums.length == 0 || nums == null) return null;
		int start = 0;
		int end = nums.length-1;
		return sortedArrayToBST(nums, start, end);
	}

	private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		int middle = (start+end)/2;

		TreeNode tree = new TreeNode(nums[middle]);
		
		if(start < middle ) tree.left = sortedArrayToBST(nums, start, middle - 1);
		if(middle < end ) tree.right = sortedArrayToBST(nums, middle + 1, end);

		return tree;
	}
}
