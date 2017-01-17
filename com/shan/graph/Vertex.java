package com.shan.graph;

import java.util.*;
public class Vertex {
	private int key;
	private List<Integer> adjEdge;
	
	public Vertex(int k){
		key = k;
		adjEdge = new ArrayList<Integer>();
	}
	
	public int getKey(){
		return key;
	}
	
	public List<Integer> getEdges(){
		return adjEdge;
	}
	
	public void addAdjVertex(int node){
		adjEdge.add(node);
	}
}
