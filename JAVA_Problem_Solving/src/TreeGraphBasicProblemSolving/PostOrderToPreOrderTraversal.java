package TreeGraphBasicProblemSolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PostOrderToPreOrderTraversal {
	
	public static List<Integer> preorder = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs = sc.nextLine().split(" ");
		
		int root = Integer.parseInt(inputs[inputs.length - 1]);
		TreeNode tree = new TreeNode(root);
		
		for (int i = inputs.length - 1; i >= 0; i--) {
			int node = Integer.parseInt(inputs[i]);
			constructTreeFromPostOrder(node, tree);
		}
		
		preOrderTraversal(tree);
		System.out.print(preorder);
		
		sc.close();
	}

	

	private static TreeNode constructTreeFromPostOrder(int value, TreeNode root) {
		
		if (root == null)
			return new TreeNode(value);

		if (value > root.val) {
			TreeNode newNode = constructTreeFromPostOrder(value, root.right);
			root.right = newNode;
		}
		if (value < root.val) {
			TreeNode newNode = constructTreeFromPostOrder(value, root.left);
			root.left = newNode;
		}

		return root;
	}
	
	private static TreeNode preOrderTraversal(TreeNode tree) {
		if (tree == null ) return null;
		preorder.add(tree.val);
		preOrderTraversal(tree.left);
		preOrderTraversal(tree.right);

		return tree;
	}

}
