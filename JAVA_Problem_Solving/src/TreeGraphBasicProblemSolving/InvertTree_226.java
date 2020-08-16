package TreeGraphBasicProblemSolving;

import java.util.Scanner;

public class InvertTree_226 {

	// INORDER: LPR
	// PREORDER: PLR
	// POSTORDER: LRP

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3); // or 3 for not symmetric

		// check mirror view is same or not after reversing
		System.out.print(findInvertTreeNode(root));

		sc.close();
	}

	// this TreeNode indicate the one tree.
	private static TreeNode findInvertTreeNode(TreeNode tree) {
		if (tree == null)
			return null;
		TreeNode left = findInvertTreeNode(tree.left);
		TreeNode right = findInvertTreeNode(tree.right);

		tree.right = left;
		tree.left = right;

		return tree;
	}

}
