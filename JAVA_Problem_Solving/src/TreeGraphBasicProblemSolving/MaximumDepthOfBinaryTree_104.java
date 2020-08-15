package TreeGraphBasicProblemSolving;

import java.util.Scanner;

public class MaximumDepthOfBinaryTree_104 {

	// INORDER: LPR
	// PREORDER: PLR
	// POSTORDER: LRP

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		// this is binary tree structure root must have left and right child
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(); // null
		root.left.right = new TreeNode(); // null
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		// inputs like: Given binary tree [3,9,20,null,null,15,7],
		
		System.out.print(findMaxDepth(root));
		sc.close();
	}

	// this TreeNode indicate the one tree.
	public static int findMaxDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		return 1 + Math.max(findMaxDepth(root.left), findMaxDepth(root.right));
	}

}
