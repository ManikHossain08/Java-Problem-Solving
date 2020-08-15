package TreeGraphBasicProblemSolving;

import java.util.Scanner;

public class SymmetricTree_101 {

	// INORDER: LPR
	// PREORDER: PLR
	// POSTORDER: LRP
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2); // or 3 for not symmetric
		
		/* Generated tree: symmetric
		 * 		1
		 * 	   / \
		 * 	  2   3
		 */
		
		// check mirror view is same or not after reversing
		System.out.print(isSymmetric(root));

		sc.close();
	}
	
	// this TreeNode indicate the one tree. 
	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSameTree(root.left, root.right);
	}

	private static boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;

		if (p.left != q.right || p.right != q.left)
			return false;

		if (p != null && q != null) {
			return (p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left));
		}

		return false;
	}

}
