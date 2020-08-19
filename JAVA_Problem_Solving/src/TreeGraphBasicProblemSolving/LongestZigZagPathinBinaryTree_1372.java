package TreeGraphBasicProblemSolving;

public class LongestZigZagPathinBinaryTree_1372 {

	public static int result = 0;

	public static void main(String args[]) {
		// input Tree-1
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.right = new TreeNode(4);
		root1.left.right.left = new TreeNode(5);
		root1.left.right.right = new TreeNode(6);
		root1.left.right.left.right = new TreeNode(7);

		// Input: root = [1,1,1,null,1,null,null,1,1,null,1]
		// Output: 4

		System.out.print(longestZigZag1(root1));

	}

	// SOLUTION-1: this piece of code is really easy
	public static int longestZigZag1(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, 1, true);
        dfs(root.right, 1, false);
        return result;
    }
    // this pie
    private static void dfs(TreeNode node, int depthCounter, boolean isLeftAlreadyVisit) {
        if (node == null) return;
        result = Math.max(result, depthCounter);
        
        dfs(node.left, 1 + (isLeftAlreadyVisit == true ? 0 : depthCounter), true);
        dfs(node.right,1 + (isLeftAlreadyVisit == true ? depthCounter : 0), false);
    }
	
    
 // SOLUTION-2: This piece of code is little bit difficult to understand
    private static int longestZigZag(TreeNode root) {

		if (root == null)
			return result;
		findZigzag(root);

		return result-1;
	}

	private static int[] findZigzag(TreeNode root) {

		if (root == null)
			return new int[] {0,0};

		int[] left = findZigzag(root.left);
		int[] right = findZigzag(root.right);

		int[] temp = new int[2];
        temp[0] = left[1] + 1;
        temp[1] = right[0] + 1;

		result = Math.max(result, Math.max(temp[0], temp[1]));

		return temp;
	}
	
}




