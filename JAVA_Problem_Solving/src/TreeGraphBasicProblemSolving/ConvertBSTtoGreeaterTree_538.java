package TreeGraphBasicProblemSolving;

import java.util.Scanner;

public class ConvertBSTtoGreeaterTree_538 {
	// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
	private static int nodeWeight = 0;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3); 
		
		// -------------- 2nd Tree----------
		TreeNode root1 = new TreeNode(6);
		root1.left = new TreeNode(4, new TreeNode(3), new TreeNode(5));
		root1.right = new TreeNode(9, new TreeNode(7), new TreeNode(10));
		// input tree: [6,4,9,3,5,7,10]
		// output tree: [32, 41, 19, 44, 37, 26, 10]
		

		// check mirror view is same or not after reversing
		System.out.print(convertBSTtoGreraterTree(root1));

		sc.close();
	}

	// this TreeNode indicate the one tree.
	private static TreeNode convertBSTtoGreraterTree(TreeNode tree) {
			if (tree == null)
				return null;
			
			if (tree != null) {
				convertBSTtoGreraterTree(tree.right);
				nodeWeight += tree.val;
				tree.val = nodeWeight;
				convertBSTtoGreraterTree(tree.left);
			}
		return tree;
	}

}


/*
 * MyCode: previous concept before before show leetcode
// this TreeNode indicate the one tree.
	private static TreeNode convertBSTtoGreraterTree(TreeNode tree) {
		int leftNode = 0, rightNode = 0;

		if (tree == null)
			return null;

		leftNode = tree.left == null ? 0 : tree.left.val;
		rightNode = tree.right == null ? 0 : tree.right.val;

		if (tree.right != null || tree.left != null) {
			tree = new TreeNode(rightNode + tree.val);
			tree.left = new TreeNode(leftNode + tree.val);
			tree.right = new TreeNode(rightNode);
			convertBST(tree.right);
			convertBST(tree.left);
		}
		return tree;
	}

*/
