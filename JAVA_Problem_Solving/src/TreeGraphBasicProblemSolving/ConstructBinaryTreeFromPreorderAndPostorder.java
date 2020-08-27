package TreeGraphBasicProblemSolving;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructBinaryTreeFromPreorderAndPostorder {

	public static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		int[] preorder = { 1, 2, 4, 5, 3, 6, 8, 9, 7 };
		int[] postorder = { 4, 5, 2, 8, 9, 6, 7, 3, 1 };

//		int[] preorder = { 2,1 };
//		int[] postorder = { 1,2 };

		TreeNode root = buildTree(preorder, postorder);

		System.out.print("Inorder Traversal: ");
		inorder(root);
	}

	public static TreeNode buildTree(int[] preorder, int[] postorder) {

		for (int i = 0; i < postorder.length; i++) {
			map.put(postorder[i], i);
		}

		AtomicInteger pIndex = new AtomicInteger(0);
		int start = 0;
		int end = preorder.length - 1;

		return buildTree(start, end, preorder, pIndex);
	}

	public static TreeNode buildTree(int start, int end, int[] preorder, AtomicInteger pIndex) {

		if (start > end)
			return null;

		TreeNode root = new TreeNode(preorder[pIndex.getAndIncrement()]);

		if (start == end) {
			return root;
		}
		int index = map.get(preorder[pIndex.get()]);

		root.left = buildTree(start, index, preorder, pIndex);
		root.right = buildTree(index + 1, end - 1, preorder, pIndex); 
		// here, end = root in postorder thats why end - 1 is considered for ending 
 
		return root;
	}

	public static void inorder(TreeNode root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.val + " ");
		inorder(root.right);
	}
}
// Inorder Traversal: 4 2 5 1 8 6 9 3 7 