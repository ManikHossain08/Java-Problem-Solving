package TreeGraphBasicProblemSolving;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

// Source Code: https://www.techiedelight.com/construct-binary-tree-from-inorder-preorder-traversal/
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

class ConstructTreeFromInorderAndPreorder {
	
	public static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {

		/* Consider below tree
		        1
		      /   \
		     /     \
		    2       3
		   /       / \
		  /       /   \
		 4       5     6
		        / \
		       /   \
		      7     8
		 */
		
		
		int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
		int[] preorder = { 1, 2, 4, 3, 5, 7, 8, 6 };

		TreeNode root = construct(inorder, preorder);

		// traverse the constructed tree
		System.out.print("Inorder  : ");
		inorderTraversal(root);

		System.out.print("\nPreorder : ");
		preorderTraversal(root);

		System.out.print("\nPostorder : ");
		postorderTraversal(root);
	}
	
	public static TreeNode construct(int[] inorder, int[] preorder) {

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		AtomicInteger pIndex = new AtomicInteger(0);

		return construct(0, inorder.length - 1, preorder, pIndex);
	}
	
	
	public static TreeNode construct(int start, int end, int[] preorder, AtomicInteger pIndex) {
		// base case
		if (start > end) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[pIndex.getAndIncrement()]);
		
		if (start == end) 
            return root; 
		
		int indexInorder = map.get(root.val);

		root.left = construct(start, indexInorder - 1, preorder, pIndex);
		root.right = construct(indexInorder + 1, end, preorder, pIndex);

		return root;
	}

	
	// Recursive function to perform inorder traversal of a binary tree
	public static void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}

	public static void preorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	public static void postorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		preorderTraversal(root.left);
		preorderTraversal(root.right);
		System.out.print(root.val + " ");
	}

}
/*
Inorder  : 4 2 1 7 5 8 3 6 
Preorder : 1 2 4 3 5 7 8 6 
Postorder : 2 4 3 5 7 8 6 1 
*/