package TreeGraphBasicProblemSolving;


public class BalancedBinaryTree_leetCode_110 {
	public static void main(String args[]) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
//		root.left.left = new TreeNode(); // null
//		root.left.right = new TreeNode(); // null
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		// input: [3,9,20,null,null,15,7] - true

		// ----------- structuring 2nd tree--------

		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(3); // null
		root1.left.right = new TreeNode(3); // null
		root1.left.left.left = new TreeNode(4); // null
		root1.left.left.right = new TreeNode(4); // null
		// Input: [1,2,2,3,3,null,null,4,4] - false

		// ----------- structuring 3nd tree--------
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2, new TreeNode(3), null);
		root2.right = new TreeNode(2, null, new TreeNode(3));
		root2.left.left = new TreeNode(3, new TreeNode(4), null);
		root2.right.right = new TreeNode(3, null, new TreeNode(4));

		// Input: [1,2,2,3,null,null,3,4,null,null,4] - false

		System.out.print(isBalancedBinaryTree(root));

	}

	private static boolean isBalancedBinaryTree(TreeNode root) {
		if (root == null)
			return true;
		int leftDepth = 0, rightDepth = 0;
		boolean isRootDepthBalanced = false;

		leftDepth = findMaxDepth(root.left);
		rightDepth = findMaxDepth(root.right);

		if (Math.abs(leftDepth - rightDepth) <= 1)
			isRootDepthBalanced = true;
		// isRootBalanced && isLeftSubTreeBalanced && isRightSubTreeBalanced = T && T && T = T else F
		return isRootDepthBalanced && isBalancedBinaryTree(root.left) && isBalancedBinaryTree(root.right);

	}

	// this TreeNode indicate the one tree (root or left or right tree).
	public static int findMaxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(findMaxDepth(root.left), findMaxDepth(root.right));
	}
}
