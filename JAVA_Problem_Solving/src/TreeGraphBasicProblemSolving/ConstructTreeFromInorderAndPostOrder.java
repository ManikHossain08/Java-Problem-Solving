package TreeGraphBasicProblemSolving;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructTreeFromInorderAndPostOrder {
	// concept :
	// https://www.youtube.com/watch?time_continue=337&v=s5XRtcud35E&feature=emb_logo
	// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
	// https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/

	public static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inpPostorder = sc.nextLine().split(" ");
		int[] postorder = new int[inpPostorder.length];

		for (int i = 0; i < inpPostorder.length; i++) {
			postorder[i] = Integer.parseInt(inpPostorder[i]);
		}

		String[] inpInorder = sc.nextLine().split(" ");
		int[] inorder = new int[inpPostorder.length];

		for (int i = 0; i < inpInorder.length; i++) {
			inorder[i] = Integer.parseInt(inpInorder[i]);
		}
		TreeNode root = constructTree(inorder, postorder);
		
		/* Consider below tree
			        1
			      /   \
			     /     \
			    2       3
			   / \      / \
			  /   \    /   \
			 4     5  6     7
			  \
			   \
			    8     
			*/
		
		// traverse the constructed tree
		System.out.print("Inorder  : ");
		inorderTraversal(root);

		System.out.print("\nPreorder : ");
		preorderTraversal(root);

		System.out.print("\nPostorder : ");
		postorderTraversal(root);

		sc.close();

	}

	private static TreeNode constructTree(int[] inorder, int[] postorder) {
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		int end = inorder.length - 1;
		AtomicInteger pIndex = new AtomicInteger(inorder.length - 1);

		return constructTree(0, end, inorder, postorder, pIndex);
	}

	private static TreeNode constructTree(int start, int end, int[] inorder, int[] postorder, AtomicInteger pIndex) {

		if (start > end)
			return null;

		TreeNode root = new TreeNode(postorder[pIndex.getAndDecrement()]);

		if (start == end)
			return root;

		int index = map.get(root.val);

		root.right = constructTree(index + 1, end, inorder, postorder, pIndex);
		root.left = constructTree(start, index - 1, inorder, postorder, pIndex);

		return root;
	}

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

//Inorder  : 4 2 1 7 5 8 3 6 
//Preorder : 1 2 4 3 5 7 8 6 
//Postorder : 2 4 3 5 7 8 6 1 
