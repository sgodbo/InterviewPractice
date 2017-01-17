package com.shan.interv;

public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		r1.right = r2;
		System.out.println(minDepth(r1));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		else {
			int rHeight = minDepth(root.right);
			int lHeight = minDepth(root.left);

			if (lHeight == 0 && rHeight != 0)
				return 1 + rHeight;
			else if (lHeight != 0 && rHeight == 0)
				return 1 + lHeight;

			return 1 + Math.min(rHeight, lHeight);
		}
	}

}
