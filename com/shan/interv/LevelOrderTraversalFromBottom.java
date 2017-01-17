package com.shan.interv;

import java.util.*;

public class LevelOrderTraversalFromBottom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> stkNodes = new ArrayList<List<Integer>>();
        if(root == null)
            return stkNodes;
        Queue<TreeNode> qNodes = new LinkedList<TreeNode>();
        Stack<List<Integer>> stk = new Stack<List<Integer>>();
        qNodes.offer(root);
        qNodes.offer(null);
        List<Integer> levelList = new ArrayList<Integer>();
        while(!qNodes.isEmpty()){
            TreeNode temp = qNodes.poll();
            if(temp != null){
                levelList.add(temp.val);
                if(temp.left != null){
                    qNodes.offer(temp.left);
                }
                if(temp.right != null){
                    qNodes.offer(temp.right);
                }
            }   else{
                List<Integer> tempLevelList = new ArrayList<Integer>(levelList);
                stk.push(tempLevelList);
                levelList.clear();
                if(!qNodes.isEmpty())
                    qNodes.offer(null);
            }
        }
        
        while(!stk.isEmpty()){
            stkNodes.add(stk.pop());
        }
        
        return stkNodes;
    }


}
