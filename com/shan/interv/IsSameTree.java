package com.shan.interv;

public class IsSameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode q1 = new TreeNode(1);
		TreeNode q2 = new TreeNode(2);
		TreeNode q3 = new TreeNode(3);
		q1.left = q2;
		q1.right = q3;
		// TreeNode r4 = new TreeNode(1);

		TreeNode p1 = new TreeNode(1);
		TreeNode p2 = new TreeNode(2);
		TreeNode p3 = new TreeNode(3);
		TreeNode p4 = new TreeNode(4);
		p1.left = p2;
		p1.right = p3;
		p3.right = p4;
		System.out.println(isSameTree(p1, q1));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			if (p == null && q == null)
				return true;
			else
				return false;
		}

		if (p.val == q.val)
			return true && isSameTree(p.left, q.left)
					&& isSameTree(p.right, q.right);
		else
			return false;
	}

}
