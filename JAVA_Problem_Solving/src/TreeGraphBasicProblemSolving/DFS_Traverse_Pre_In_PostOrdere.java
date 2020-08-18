package TreeGraphBasicProblemSolving;

public class DFS_Traverse_Pre_In_PostOrdere {
	
	// PREORDER:  PLR
	// INORDER:   LPR
	// POSTORDER: LRP
	
	public static void main(String args[]) {
		// input Tree-1
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		root1.right = new TreeNode(3);
		//root1.right.right.right = new TreeNode(8);
		
		System.out.print("PreOrder Traveral: ");
		findPreOrderTraveral(root1);
		System.out.println();
		System.out.print("InOrder Traveral: ");
		findInOrderTraveral(root1);
		System.out.println();
		System.out.print("PostOrder Traveral: ");
		findPostOrderTraveral(root1);
		
	}

	private static void findPostOrderTraveral(TreeNode root1) {
		if(root1 == null) return ;
		findPostOrderTraveral(root1.left);
		findPostOrderTraveral(root1.right);
		System.out.print(root1.val);
		
	}

	private static void findInOrderTraveral(TreeNode root1) {
		if(root1 == null) return ;
		findInOrderTraveral(root1.left);
		System.out.print(root1.val);
		findInOrderTraveral(root1.right);
	}

	private static void findPreOrderTraveral(TreeNode root1) {
		if(root1 == null) return ;
		System.out.print(root1.val);
		findPreOrderTraveral(root1.left);
		findPreOrderTraveral(root1.right);
	}
}
