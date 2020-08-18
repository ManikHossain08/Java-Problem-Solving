package TreeGraphBasicProblemSolving;

public class CousinsinBinaryTree_993 {
	
	public static int nodeDepthx = 1;
	public static int nodeDepthy = 1;
	public static TreeNode parentx;
	public static TreeNode parenty;

	public static void main(String args[]) {
		// input Tree-1
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
		root1.right = new TreeNode(5, new TreeNode(6), new TreeNode(7));
		root1.right.right.right = new TreeNode(8);

		// input Tree-2
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2, null, new TreeNode(4));
		root2.right = new TreeNode(3);

		System.out.print(isCousinsinBinaryTree(root2, 4, 3));
	}

	private static boolean isCousinsinBinaryTree(TreeNode root, int x, int y) {

		findNodeDepth(root, null, x, y, 1);
		return Math.abs(nodeDepthx - nodeDepthy) == 0 && parentx != parenty;
	}

	private static void findNodeDepth(TreeNode root, TreeNode parent, int x, int y, int depthCounter) {

		if (root == null)
			return;

		if (x == root.val) {
			nodeDepthx = depthCounter;
			parentx = parent;
		}

		if (y == root.val) {
			nodeDepthy = depthCounter;
			parenty = parent;
		}

		findNodeDepth(root.left, root, x, y, depthCounter + 1);
		findNodeDepth(root.right, root, x, y, depthCounter + 1);
	}

}
