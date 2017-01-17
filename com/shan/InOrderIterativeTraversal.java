package com.shan;

import java.util.*;


public class InOrderIterativeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		
		t1.setLeft(t2);
		t1.setRight(t3);
		
		t2.setLeft(t4);
		t2.setRight(t5);
		
		t3.setLeft(t6);
		t3.setRight(t7);
		
		inOrderTraversal(t1,5);
		
		System.out.println();
		System.out.println();
		System.out.println();
		postOrderTraversal(t1);
		levelOrder(t1);
		System.out.println(findMax(t1) + "is the max");
		hieghtIterative(t1);
		
	}

	private static void hieghtIterative(TreeNode t1) {
		// TODO Auto-generated method stub
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(t1);
		TreeNode tmp;
		while(!q.isEmpty()){
			if((tmp = q.peek()).getLeft() != null && tmp.getRight() != null){
				q.offer(tmp.getLeft());
				q.offer(tmp.getRight());
			}
				
		}
	}

	private static int findMax(TreeNode t1) {
		// TODO Auto-generated method stub
		TreeNode current = t1;
		int max = Integer.MIN_VALUE;
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;
		int interMax = Integer.MIN_VALUE;
		if(current.getLeft() != null && current.getRight() != null){
			leftMax = findMax(current.getLeft());
			rightMax = findMax(current.getRight());
			interMax = leftMax > rightMax ? leftMax:rightMax;
			max = current.getData() > interMax ? current.getData():interMax;
		}	else{
			return current.getData();
		}
		
		//System.out.println(max);
		return max;
	}

	private static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if (root == null)
			return res;
		// Initialization
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		q.offer(null);
		ArrayList<Integer> curr = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			TreeNode tmp = q.poll();
			if (tmp != null) {
				curr.add(tmp.data);
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				if (tmp.right != null)
					q.offer(tmp.right);
			} else {
				ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
				res.add(c_curr);
				curr.clear(); // Java will clear the reference, so have to new an new ArrayList. 
				// completion of a level;
				if (!q.isEmpty())
					q.offer(null);
			}
		}
		return res;
    }

	private static void inOrderTraversal(TreeNode t1, int search) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode current = t1;
		boolean visited = false;
		
		do{
			if(current.getData() == search)
				break;
			else if(current.left == null && current.right == null){
				System.out.println(s.pop().getData());
				visited = true;
			}	else if(visited){
				System.out.println(s.pop().getData());				
				visited = false;
			}	else{	
				if(!s.isEmpty())
					current = s.pop();
				s.push(current.right);
				s.push(current);
				s.push(current.left);
			}
			if(!s.isEmpty())
				current = s.peek();		
		}while(!s.isEmpty());
	
	}

	private static void postOrderTraversal(TreeNode t1) {
		// TODO Auto-generated method stub
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode current = t1;
		boolean visited = false;
		s.push(current);
		
		while(!s.isEmpty()){
			if(current.left == null && current.right == null){
				System.out.println(s.pop().getData());
				visited = true;
			}	else if(visited){
				System.out.println(s.pop().getData());				
				visited = false;
			}	else{				
				s.push(current.right);
				s.push(current.left);
			}
			current = s.peek();
			if(s.size() == 1){
				System.out.println(s.pop().getData());
				break;
			}		
		}
	}

}
