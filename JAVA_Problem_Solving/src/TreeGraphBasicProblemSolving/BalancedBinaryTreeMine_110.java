package TreeGraphBasicProblemSolving;

public class BalancedBinaryTreeMine_110 {
	
	public static void main(String args[]) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
//		root.left.left = new TreeNode(); // null
//		root.left.right = new TreeNode(); // null
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		// input: [3,9,20,null,null,15,7]:
		
		// ----------- structuring 2nd tree--------
//		root.right.left.left = new TreeNode(5);
//		root.right.left.right = new TreeNode(6);
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(3); // null
		root1.left.right = new TreeNode(3); // null
		root1.left.left.left = new TreeNode(4); // null
		root1.left.left.right = new TreeNode(4); // null
		// Input: [1,2,2,3,3,null,null,4,4]
		
		// ----------- structuring 3nd tree--------
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2,new TreeNode(3),null);
		root2.right = new TreeNode(2, null, new TreeNode(3));
		root2.left.left = new TreeNode(3, new TreeNode(4), null); 
		root2.right.right = new TreeNode(3, null, new TreeNode(4)); 

		// Input: [1,2,2,3,null,null,3,4,null,null,4]

		System.out.print(isBalancedBinaryTree(root2));

	}

	private static boolean isBalancedBinaryTree(TreeNode root) {
		if (root == null)
			return true;
		return findMaxDepth(root) != -1;
	}

	// this TreeNode indicate the one tree (left or right tree).
	public static int findMaxDepth(TreeNode root) {
		int leftDepth, rightDepth;
		if ((root == null))
			return 0;
		if ((leftDepth = findMaxDepth(root.left)) == -1)
			return -1;
		if ((rightDepth = findMaxDepth(root.right)) == -1)
			return -1;

		if (Math.abs(leftDepth - rightDepth) > 1)
			return -1;

		return 1 + Math.max(leftDepth, rightDepth);
	}
}

