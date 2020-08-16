package TreeGraphBasicProblemSolving;

public class SameTree_100 {
	
	// INORDER:   LPR
	// PREORDER:  PLR
	// POSTORDER: LRP
	
	public static void main(String args[]) {
		
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
		
		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(3);
		
		System.out.print(isSameTree(p, q));

	}
	// here each node (root, left, right) is counting as a root node 
	// and comparing the value in the end. 
	private static boolean isSameTree(TreeNode p, TreeNode q) {
		 
		if (p == null && q == null) return true;
		if (p != null && q != null) {
			// isRootNode_ValueMatched && isLeftNode_ValueMatched  && isRightNode_ValueMatched
			// Ultimately I am always checking each node value by p.val == q.val this statement
			return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		
		return false;
	}
	
	
}

