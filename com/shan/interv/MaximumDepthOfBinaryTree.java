package com.shan.interv;


public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		r1.right = r2;
		System.out.println(maxDepth(r1));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		else {
			int rHeight = maxDepth(root.right);
			int lHeight = maxDepth(root.left);

			if (lHeight == 0 && rHeight != 0)
				return 1 + rHeight;
			else if (lHeight != 0 && rHeight == 0)
				return 1 + lHeight;

			return 1 + Math.max(rHeight, lHeight);
		}
	
    }


}
