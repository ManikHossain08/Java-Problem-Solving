package AVL_Tree_From_Binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// INORDER:   LPR
// PREORDER:  PLR
// POSTORDER: LRP

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int value) {
		this.val = value;
	}

	TreeNode(int value, TreeNode left, TreeNode right) {
		this.val = value;
		this.left = left;
		this.right = right;
	}
}

public class AVL_Tree_Detect_From_Binary {
	// FOR GENERATING TREE I AM FOLLOWINGN THIS CONCEPT
	// https://www.crondose.com/2016/06/create-a-binary-search-tree-array/

	public static TreeNode tree = new TreeNode();
	public static List<Integer> preorder = new ArrayList<Integer>();

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String[] inputs = sc.nextLine().split(" ");
		int[] elements = new int[inputs.length - 1];
		// int[] elements = { 4, 2, 6, 3, 5, 7, 1 };
		for (int i = 0; i < inputs.length; i++) {
			int value = Integer.parseInt(inputs[i]);
			if (value != -1)
				elements[i] = value;
		}

		generateBSTFromArray(elements);

		int isAVL = checkIsAVL(tree);
		if (isAVL != -1) {
			preOrderTraveral(tree);
			System.out.print(preorder);
		} else {
			System.out.print("NOT");
		}

		sc.close();
	}

	private static void generateBSTFromArray(int[] elements) {
		if (elements.length > 0)
			tree = new TreeNode(elements[0]);
		for (int i = 1; i < elements.length; i++) {
			generateByComaparingValue(elements[i], tree);
		}

	}

	private static int checkIsAVL(TreeNode tree) {

		if (tree == null)
			return 0;

		int leftDepth, rightDepth;
		if ((leftDepth = checkIsAVL(tree.left)) == -1)
			return -1;
		if ((rightDepth = checkIsAVL(tree.right)) == -1)
			return -1;

		if (Math.abs(leftDepth - rightDepth) > 1)
			return -1;

		return 1 + Math.max(leftDepth, rightDepth);
	}

	private static TreeNode generateByComaparingValue(int value, TreeNode root) {

		if (root == null)
			return new TreeNode(value);

		if (value > root.val) {
			TreeNode newNode = generateByComaparingValue(value, root.right);
			root.right = newNode;
		}
		if (value < root.val) {
			TreeNode newNode = generateByComaparingValue(value, root.left);
			root.left = newNode;
		}

		return root;
	}

	private static List<Integer> preOrderTraveral(TreeNode root) {
		if (root == null)
			return null;
		preorder.add(root.val);
		preOrderTraveral(root.left);
		preOrderTraveral(root.right);

		return preorder;
	}
}
