package com.shan.graph;

import java.util.*;
public class EvenTree {

	static class Node{
		int id;
		List<Node> children;
		int numOfNodesInTree;
		
		public Node(int id){
			this.id = id;
			children = new ArrayList<Node>();
			numOfNodesInTree = 1;
		}
		
		public void addChildren(Node n){
			children.add(n);
			//numOfNodesInTree += n.numOfNodesInTree;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		List<Node> setOfNodes = new ArrayList<Node>();
		for(int i = 0;i < n;i++){
			Node n1 = new Node(i+1);
			setOfNodes.add(n1);
		}
		
		for(int i = 0;i < m;i++){
			Node n1 = setOfNodes.get(in.nextInt()-1);
			Node n2 = setOfNodes.get(in.nextInt()-1);
			
			n2.addChildren(n1);
			
		}
		
		calcNodesInSubTreeRec(setOfNodes.get(0));
		System.out.println(findEvenTreePossiblities(setOfNodes.get(0)));		
		
	}
	private static int findEvenTreePossiblities(Node node) {
		// TODO Auto-generated method stub
		int num = 0;
		if(node.numOfNodesInTree != 1){
			
			for(Node n:node.children){
				if(n.numOfNodesInTree%2 == 0)
					num++;
			}
		}
			
		return num;
	}
	private static int calcNodesInSubTreeRec(Node node) {
		// TODO Auto-generated method stub
		if(node.children.isEmpty()){
			node.numOfNodesInTree = 1;
			return 1;
		}
		else{
			int sum = 1;
			for(Node child:node.children){
				sum += calcNodesInSubTreeRec(child);
			}
			
			node.numOfNodesInTree = sum;
			
			return sum;
		}
	}

}
