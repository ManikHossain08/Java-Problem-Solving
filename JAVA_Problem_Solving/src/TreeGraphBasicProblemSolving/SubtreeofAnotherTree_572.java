package TreeGraphBasicProblemSolving;

public class SubtreeofAnotherTree_572 {

	public static void main(String args[]) {

		// Source Tree
		TreeNode root1 = new TreeNode(6);
		root1.right = new TreeNode(4, new TreeNode(5), new TreeNode(7));
		root1.left = new TreeNode(1, new TreeNode(2), new TreeNode(3));


		// Matching tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		// ---- 2nd input----------
		// Source Tree
		TreeNode root2 = new TreeNode(3);
		root2.right = new TreeNode(5);
		root2.left = new TreeNode(4, new TreeNode(1), new TreeNode(2)); // true
		//root2.left.left = new TreeNode(10); // if add this node then //  false

		// Matching tree
		TreeNode root3 = new TreeNode(4);
		root3.left = new TreeNode(1);
		root3.right = new TreeNode(2);
		
		// source, trans
		
		System.out.print(isSubtree(root2, root3));
	}

	private static boolean isSubtree(TreeNode source, TreeNode trans) {

		if(source == null || trans == null) return false;
		
		boolean machingWithParent_SubTree = isMatched(source, trans);
		boolean machingWithLeft_SubTree = isSubtree(source.left, trans);
		boolean machingWithRight_SubTree = isSubtree(source.right, trans);
		
		return (machingWithParent_SubTree || machingWithLeft_SubTree || machingWithRight_SubTree);
	}


	private static boolean isMatched(TreeNode source, TreeNode trans) {
		if ((source == null && trans == null))
			return true;
		if (source == null || trans == null)
			return false;
		return (source.val == trans.val) && isMatched(source.left, trans.left) && isMatched(source.right, trans.right);
	}
}


/*

// My Fist concept was like this
 
 public boolean isSubtree(TreeNode source, TreeNode trans) {
        if ((source == null && trans == null))
			return true;
		if (source == null || trans == null)
			return false;

		if (source != null && trans != null && result == false) {
			if (result == false)
				result = isSubtree(source.left, trans);
			else return result;
			if (result == false)
				result = isSubtree(source.right, trans);
			else return result;
		}
		return (source.val == trans.val) && isSubtree(source.left, trans.left) && isSubtree(source.right, trans.right);
		//isMatched(source, trans);
	}

*/
