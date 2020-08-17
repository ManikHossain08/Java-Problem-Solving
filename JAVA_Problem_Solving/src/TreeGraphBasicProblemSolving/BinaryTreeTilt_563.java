package TreeGraphBasicProblemSolving;

public class BinaryTreeTilt_563 {

	private static int tiltWeight = 0;

	public static void main(String args[]) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		// -------------- 2nd Tree----------
		TreeNode root1 = new TreeNode(6);
		root1.left = new TreeNode(4, new TreeNode(3), new TreeNode(5));
		root1.right = new TreeNode(9, new TreeNode(7), new TreeNode(10));
		// input tree: [6,4,9,3,5,7,10]
		// output tree: 19

		// -------------- 3rd Tree----------
		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(2, new TreeNode(3), new TreeNode(1));
		root2.right = new TreeNode(4, new TreeNode(6), new TreeNode(5));
		// input tree: [3,2,4,3,1,6,5]
		// output tree: 12

		// -------------- 4th Tree----------
		TreeNode root3 = new TreeNode(1);
		root3.left = new TreeNode(2, new TreeNode(4), null);
		root3.right = new TreeNode(3, new TreeNode(5), null);
		// input tree: [1,2,3,4,null,5,null]
		// output tree: 11

		System.out.print(findTilt(root3));

	}

	private static int findTilt(TreeNode root) {

		binaryTreeTilt(root);
		return tiltWeight;
	}

	private static int binaryTreeTilt(TreeNode root) {

		if (root == null)
			return 0;
		int left = binaryTreeTilt(root.left);
		int right = binaryTreeTilt(root.right);
		tiltWeight += Math.abs(left - right);
		
		// this indicate/return node weight
		return left + right + root.val;
	}

}

/*
 // My previous concept:
 
  public int findTilt(TreeNode root) {
        if (root == null)
			return 0;
		nodeWeight = 0;
		int leftNodeSum = binaryTreeTilt(root.left);
		nodeWeight = 0;
		int rightNodeSum = binaryTreeTilt(root.right);

		
		return tiltWeight + Math.abs(leftNodeSum - rightNodeSum);
	}

	private int binaryTreeTilt(TreeNode root) {

		if (root == null)
			return 0;
		if (root != null) {
			nodeWeight += root.val;
			// was calculating only specific node not along with sub (bottom) node
			tiltWeight += Math.abs((root.left != null? root.left.val : 0) 
					- (root.right != null? root.right.val : 0));
			
			binaryTreeTilt(root.left);
			binaryTreeTilt(root.right);

		}

		return nodeWeight;
	}
 */


