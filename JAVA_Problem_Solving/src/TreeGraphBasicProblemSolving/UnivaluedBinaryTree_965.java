package TreeGraphBasicProblemSolving;

public class UnivaluedBinaryTree_965 {
	public static void main(String args[]) {

		// input Tree
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(1, new TreeNode(1), new TreeNode(1));
		root1.right = new TreeNode(1, new TreeNode(1), new TreeNode(1));
		root1.right.right = new TreeNode(1);

		System.out.print(isUnivaluedBinaryTree(root1));
	}

	private static boolean isUnivaluedBinaryTree(TreeNode root) {
		return valueMatching(root, root.val);
	}

	private static boolean valueMatching(TreeNode root, int rootval) {
		if (root == null) return true;
		return root.val == rootval && valueMatching(root.left, rootval) && valueMatching(root.right, rootval);
	}
}
