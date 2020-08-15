package TreeGraphBasicProblemSolving;

import java.util.Scanner;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int value){
		this.val = value;
	}
}


public class SameTree_100 {
	
	// INORDER:   LPR
	// PREORDER:  PLR
	// POSTORDER: LRP
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		//List<List<String>> tree = new ArrayList<List<String>>();
		
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
		
		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(3);
		
		System.out.print(isSameTree(p, q));
		
		
		sc.close();
	}

	private static boolean isSameTree(TreeNode p, TreeNode q) {
		 
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		if (p.val != q.val) return false;
		
		if (p != null && q != null) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}

		return false;
	}
	
	
}

