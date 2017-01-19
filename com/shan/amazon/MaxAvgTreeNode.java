package com.shan.amazon;
import java.util.*;

public class MaxAvgTreeNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();
		Node n7 = new Node();
		Node n8 = new Node();
		
		n8.val = 8;
		n7.val = 15;
		
		n6.val = 3;		
		n5.val = 2;
		n4.val = 11;
		
		n3.val = 18;
		n2.val = 12;
		
		n1.val = 20;
		
		n2.subNode.add(n4);
		n2.subNode.add(n5);
		n2.subNode.add(n6);
		
		n3.subNode.add(n7);
		n3.subNode.add(n8);
		
		n1.subNode.add(n2);
		n1.subNode.add(n3);
		
		Node maxNode = findMaxAverage(n1);
		System.out.println(maxNode.val);
	}
	
	private static Node findMaxAverage(Node n1) {
		// TODO Auto-generated method stub
		Node maxNode = new Node();
		maxNode.val = Integer.MIN_VALUE;
		resNode r1 = findMaxAvgRec(n1);
		return r1.maxNode;
	}

	private static resNode findMaxAvgRec(Node n) {
		// TODO Auto-generated method stub
		resNode r1 = new resNode();
		if(n == null){
			return r1;
		}
		if(n.subNode.isEmpty()){
			
			r1.sum = n.val;
			r1.nums = 1;
			return r1;
		}
		int sum = 0;
		int nums = 0;
		float maxAvg = -1.0f;
		for(Node e:n.subNode){
			resNode temp = findMaxAvgRec(e);
			sum += temp.sum;
			nums += temp.nums;
			float tempAvg = (float)temp.sum/temp.nums;
			if(temp.nums != 1 && maxAvg < tempAvg){
				r1.maxNode = temp.maxNode;
				maxAvg = tempAvg;
			}
		}
		sum += n.val;
		nums += 1;
		float avg = (float)sum/nums;
		r1.sum = sum;
		r1.nums = nums;
		if(avg > maxAvg && n.subNode.size() != 0){
			r1.maxNode = n;
		}
		
		return r1;
	}
	
	static class resNode{
		int sum = 0;
		int nums = 0;
		Node maxNode;
	}

	static class Node{
		int val = 0;
		ArrayList<Node> subNode = new ArrayList<Node>();
	}

}
