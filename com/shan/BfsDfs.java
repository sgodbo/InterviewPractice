package com.shan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BfsDfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9= new TreeNode(9);
		t1.setLeft(t2);
		t1.setRight(t3);
		
		t2.setLeft(t4);
		t2.setRight(t5);
		
		t3.setLeft(t6);
		t3.setRight(t7);
		
		t4.setLeft(t8);
		t4.setRight(t9);
		
		//Bfs(t1);
		//System.out.println(Math.ceil(Dfs(t1)/2));
		zigZagTraversal(t1);
		String s = "ILILL";
		//replaceSpaceWithAscii("My Name is John Smith   ");
	}
	
	public String stringIntersect(String s1, String s2){
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		Map<Character,Integer> m1 = new TreeMap<Character,Integer>();
		Map<Character,Integer> m2 = new TreeMap<Character,Integer>();
		int tempCount = 0;
		for(char c: arr1){
			if(m1.containsKey(c)){
				tempCount = m1.get(c);
				m1.put(c, tempCount+1);
			}	else{
				m1.put(c, 1);
			}
		}
		for(char c: arr2){
			if(m2.containsKey(c)){
				tempCount = m2.get(c);
				m2.put(c, tempCount+1);
			}	else{
				m2.put(c, 1);
			}
		}
		
		for(Entry<Character,Integer> entry:m1.entrySet()){
			if(m2.containsKey(arg0))
		}
	}
	
	private static TreeNode constructTreeFromPreOrder(char[] sArr,int start){
		
		TreeNode t1 = new TreeNode(sArr[start]);
		if(start < sArr.length-1){
		if(sArr[start+1] == 'L'){
			t1.setLeft(new TreeNode('L'));
			t1.setRight(constructTreeFromPreOrder(sArr, start+2));
		}	else{
			t1.setLeft(constructTreeFromPreOrder(sArr, start+1));
		}
		}
		return t1;
	}
	
	private static void zigZagTraversal(TreeNode t1) {
		// TODO Auto-generated method stub
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(t1);
		q.offer(null);
		TreeNode temp;
		boolean switchOrder = false;
		Queue<TreeNode> tempQ = new LinkedList<TreeNode>();
		Stack<TreeNode> tempS = new Stack<TreeNode>();
		while (q.size() != 1) {
			temp = q.poll();
			if (temp == null) {
				q.offer(null);
				while(!tempS.isEmpty()){
					System.out.println(tempS.pop().getData());
				}
				while(!tempQ.isEmpty()){
					System.out.println(tempQ.poll().getData());
				}
				switchOrder = !switchOrder;
			} else {
				//System.out.println(temp.getData());
				if (!switchOrder) {
					if (temp.getLeft() != null){
						q.offer(temp.getLeft());
						tempS.push(temp.getLeft());}
					if (temp.getRight() != null){
						q.offer(temp.getRight());
						tempS.push(temp.getRight());}
				}	else{
					if (temp.getLeft() != null){
						q.offer(temp.getLeft());
						tempQ.offer(temp.getLeft());}
					if (temp.getRight() != null){
						q.offer(temp.getRight());
						tempQ.offer(temp.getRight());}
				}
			}
		}
	}

	public static void replaceSpaceWithAscii(String s1){
        char[] arr = s1.toCharArray();
        Queue<Character> q = new LinkedList<Character>();
        boolean skip = false;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == ' ' && !skip){
                q.offer('%');
                q.offer('2');
                q.offer('0');
                if(arr[i+1] == ' '){
                	skip = true;
                }
            }	else{
            	q.offer(arr[i]);
            }
        }
        
        while(!q.isEmpty()){
        	System.out.print(q.poll());
        }
    }

	private static int Dfs(TreeNode t1) {
		// TODO Auto-generated method stub
		int count = 0;
		if(t1 != null){
			//System.out.println(t1.getData());
			int count1 = Dfs(t1.left);
			int count2 = Dfs(t1.right);
			count = count1 + count2;
		}	
		
		return count+1;
	}

	private static void Bfs(TreeNode t1) {
		// TODO Auto-generated method stub
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(t1);
		q.offer(null);
		TreeNode tmp = new TreeNode();
		int level = 1;
		int roots = 0;
		while(q.size() != 1){
			tmp = q.poll();
			if(tmp != null){
				//System.out.println(tmp.getData());
				if(tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				/*else
					break;*/
				if(tmp.getRight() != null)
					q.offer(tmp.getRight());
				/*else
					break;*/
				else if(tmp.getLeft() == null && tmp.getRight() == null){
					roots++;
				}
				
			}	else{
				level++;
				q.offer(null);
			}
		}
		System.out.println(roots);
		System.out.println(tmp.getData());
		System.out.println(level);
	}	

}
