package com.shan.interv;

import java.util.*;

import com.shan.interv.LevelOrderTraversal.TreeNode;


public class BSTDeletion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(6);
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(7);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		
		System.out.println(deleteNode(t1, 3).val);
		
		List<List<Integer>> list = levelOrder(t1);
		for(List<Integer> l:list){
			for(int num:l){
				System.out.print(num + ",");
			}
		}
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
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
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}	

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;  
        if(root.val == key){
            return performRotations(root);
        }
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
    }
    
    public static TreeNode performRotations(TreeNode root){
        if(root.right == null && root.left == null){
            return null;
        }   else{
            if(root.right == null){
                TreeNode left = root.left;
                TreeNode leftRight = left.right;
                if(leftRight == null){
                	TreeNode tempRight = root.right;
                    root = left;
                    root.right = tempRight;
                }   else{
                    while(leftRight.right != null){
                        leftRight = leftRight.right;
                    }
                    root.val = leftRight.val;
                    leftRight = leftRight.left;
                }
            }   else{
                TreeNode right = root.right;
                TreeNode rightLeft = right.left;
                if(rightLeft == null){
                	TreeNode tempLeft = root.left;
                    root = right;
                    root.left = tempLeft;
                }   else{
                    while(rightLeft.left != null){
                        rightLeft = rightLeft.left;
                    }
                    root.val = rightLeft.val;
                    rightLeft = rightLeft.right;
                }
            }
            
            return root;
        }
            
    }
    
    


}
