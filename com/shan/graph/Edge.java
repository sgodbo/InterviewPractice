package com.shan.graph;

public class Edge implements Comparable<Edge>{
	private int srcNode;
	private int destNode;
	private int weight;
	
	
	public Edge(int src,int dest,int wt){
		srcNode = src;
		destNode = dest;
		weight = wt;
	}
	
	public int compareTo(Edge e){
		return this.weight - e.weight;
	}
	
	public int getAdjVertex(int k){
		if(srcNode == k)
			return destNode;
		if(destNode == k)
			return srcNode;
		return Integer.MIN_VALUE;
	}
	
	public int getDirectedAdjVertex(int k){
		if(srcNode == k)
			return destNode;
		return Integer.MIN_VALUE;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public int getSource(){
		return srcNode;
	}
	
	public int getDest(){
		return destNode;
	}
}
