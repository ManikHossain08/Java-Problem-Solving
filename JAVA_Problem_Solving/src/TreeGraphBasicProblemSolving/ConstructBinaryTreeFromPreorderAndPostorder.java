package TreeGraphBasicProblemSolving;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructBinaryTreeFromPreorderAndPostorder {
	
	public static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		int[] preorder = { 1, 2, 4, 5, 3, 6, 8, 9, 7 };
		int[] postorder = { 4, 5, 2, 8, 9, 6, 7, 3, 1 };

		TreeNode root = buildTree(preorder, postorder);

		System.out.print("Inorder Traversal: ");
		inorder(root);
	}

	// Construct a full binary tree from preorder and postorder sequence
	public static TreeNode buildTree(int[] preorder, int[] postorder) {
		// map is used to efficiently find index of any element in given
		// postorder sequence
		
		for (int i = 0; i < postorder.length; i++) {
			map.put(postorder[i], i);
		}

		// pIndex stores index of next TreeNode in the preorder sequence
		AtomicInteger pIndex = new AtomicInteger(0);

		// set range [start, end] for subtree formed by postorder sequence
		int start = 0;
		int end = preorder.length - 1;

		// construct the binary tree and return it
		return buildTree(start, end, preorder, pIndex);
	}



	// A recursive function to construct a full binary tree from given preorder
	// and postorder sequence
	public static TreeNode buildTree(int start, int end, int[] preorder, AtomicInteger pIndex) {
		// Consider the next item from the given preorder sequence
		// This item would be the root TreeNode of subtree formed by
		// the postorder[start, end] and increment pIndex
		TreeNode root = new TreeNode(preorder[pIndex.getAndIncrement()]);

		// return if all keys are processed
		if (pIndex.get() == preorder.length) {
			return root;
		}

		// find the index of next key in postorder sequence to determine the
		// boundary of left and right subtree of current root TreeNode
		int index = map.get(preorder[pIndex.get()]);

		// fill the left and right subtree together
		if (start <= index && index + 1 <= end - 1) {
			// build the left subtree
			root.left = buildTree( start, index, preorder, pIndex);

			// build the right subtree
			root.right = buildTree(index + 1, end - 1, preorder, pIndex);
		}

		return root;
	}
	
	// Recursive function to perform inorder traversal of a binary tree
	public static void inorder(TreeNode root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.val + " ");
		inorder(root.right);
	}
}
