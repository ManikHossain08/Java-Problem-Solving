package TreeGraphBasicProblemSolving;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
	public static List<Integer> inorderTree = new ArrayList<Integer>();
	public static void main(String args[]) {
		// input Tree-1
		TreeNode root1 = new TreeNode(1);
		root1.right = new TreeNode(2, new TreeNode(3), null);
		// [1,null,2,3]

		System.out.print(inOrderTraveral(root1));
	
	}

	private static List<Integer> inOrderTraveral(TreeNode root1) {
		if (root1 == null)
			return null;
		inOrderTraveral(root1.left);
		inorderTree.add(root1.val);
		inOrderTraveral(root1.right);
		
		return inorderTree;
	}
}
