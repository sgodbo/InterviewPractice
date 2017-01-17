package com.shan.interv;


public class IsABalancedTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(2);
		TreeNode r4 = new TreeNode(3);
		TreeNode r5 = new TreeNode(3);
		TreeNode r6 = new TreeNode(3);
		TreeNode r7 = new TreeNode(3);
		TreeNode r8 = new TreeNode(4);
		TreeNode r9 = new TreeNode(4);
		TreeNode r10 = new TreeNode(4);
		TreeNode r11 = new TreeNode(4);
		TreeNode r12 = new TreeNode(4);
		TreeNode r13 = new TreeNode(4);
		TreeNode r14 = new TreeNode(5);
		TreeNode r15 = new TreeNode(5);
		
		r1.left = r2;
		r1.right = r3;
		
		r2.left = r4;
		r2.right = r5;
		
		r3.left = r6;
		r3.right = r7;
		
		r4.left = r8;
		r4.right = r9;
		
		r5.left = r10;
		r5.right = r11;
		
		r6.left = r12;
		r6.right = r13;
		
		r8.left = r14;
		r8.right = r15;
		System.out.println(isBalanced(r1));
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
 
		if (getHeight(root) == -1)
			return false;
 
		return true;
	}
 
	public static int getHeight(TreeNode root) {
		if (root == null)
			return 0;
 
		int left = getHeight(root.left);
		int right = getHeight(root.right);
 
		if (left == -1 || right == -1)
			return -1;
 
		if (Math.abs(left - right) > 1) {
			return -1;
		}
 
		return Math.max(left, right) + 1;
 
	}


}
