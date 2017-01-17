package com.shan.interv;

import java.util.*;

public class LevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderNodesList = new ArrayList<List<Integer>>();
        Queue<TreeNode> qNodes = new LinkedList<TreeNode>();
        if(root == null)
            return levelOrderNodesList;
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
                levelOrderNodesList.add(tempLevelList);
                levelList.clear();
                if(!qNodes.isEmpty())
                    qNodes.offer(null);
            }
        }
        
        return levelOrderNodesList;
    }


}
