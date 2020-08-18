package TreeGraphBasicProblemSolving;

public class MergeTwoBinaryTrees_617_leetCodeSolution {

	public static TreeNode root = new TreeNode(0);

	public static void main(String args[]) {

		// input Tree-1
		TreeNode root1 = new TreeNode(1);
		//root1.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
		root1.right = new TreeNode(5, new TreeNode(6), new TreeNode(7));
		root1.right.right.right = new TreeNode(1);

		// input Tree
		TreeNode root2 = new TreeNode(8);
		root2.left = new TreeNode(9, new TreeNode(10), new TreeNode(11));
		root2.right = new TreeNode(12, null, null);
		// root2.right.right = new TreeNode(1);
		
	
		TreeNode result = mergeTrees(root1, root2);
		System.out.print(result);

	}

	private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		
		if(root1 == null) return root2;
		if(root2 == null) return root1;
		
		root1.val += root2.val;
		root1.left = mergeTrees(root1.left, root2.left);
		root1.right = mergeTrees(root1.right, root2.right);

		return root1;
	}

}
