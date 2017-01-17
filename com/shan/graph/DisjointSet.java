package com.shan.graph;

import java.util.*;
public class DisjointSet {
	class Node{
		int key;
		Node parent;
		int rank;
		public Node(int k){
			key = k;
			rank = 0;
		}
	}
	private Map<Integer,Node> mapDisjoinSet;
    private Map<Integer,Long> mapSetSize;
	public DisjointSet(){
		mapDisjoinSet = new HashMap<Integer,Node>();
        mapSetSize = new HashMap<Integer,Long>();
	}
	public int findSet(int key){
		return findSet(mapDisjoinSet.get(key)).key;
	}

	public Node findSet(Node node) {
		Node parent = node.parent;

		if (parent != node) {
			parent = findSet(parent);
			node.parent = parent;
		}
		return node.parent;
	}
	
	public void makeSet(int k){
		if(!mapDisjoinSet.containsKey(k)){
			Node node = new Node(k);
			node.parent = node;
			mapDisjoinSet.put(k, node);
			mapSetSize.put(k, (long)1);
		}
	}
	public void union(int k1,int k2){
		Node parent1 = findSet(mapDisjoinSet.get(k1));
		Node parent2 = findSet(mapDisjoinSet.get(k2));
		
		if(parent1.rank >= parent2.rank){
			if(parent1.rank == parent2.rank){
				parent2.rank = 0;
				parent1.rank++;
			}
			parent2.parent = parent1;
			long parent2size = mapSetSize.get(parent2.key);
			mapSetSize.remove(parent2.key);
			increaseVal(parent1.key,parent2size);
		}	else{
			parent1.parent = parent2;
			long parent1size = mapSetSize.get(parent1.key);
			mapSetSize.remove(parent1.key);
			increaseVal(parent2.key,parent1size);
		}
	}
	
	public void increaseVal(int key,long inc){
		long size = inc;
		if(mapSetSize.containsKey(key)){
			size += mapSetSize.get(key);
		}
		mapSetSize.put(key, size);
	}
	public Map<Integer,Long> getMapOfSizeOfSets(){
        return mapSetSize;
    }
	
}
