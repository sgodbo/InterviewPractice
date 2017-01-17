package com.shan.graph;
import java.util.*;
public class BinaryHeapMap<T> {
	class Node<T> implements Comparable<Node<T>>{
		T key;
		int val;
		
		public int compareTo(Node<T> n){
			return this.val - n.val;
		}
		
		public Node(T k,int v){
			key = k;
			val = v;
		}
	}
	/* 1,35  1->(1,35)  (1,35)
	 * */
	private Queue<Node<T>> minHeap;
	private Map<T,Node<T>> nodeMap;
	
	public BinaryHeapMap(){
		minHeap = new PriorityQueue<Node<T>>();
		nodeMap = new HashMap<T,Node<T>>();
	}
	
	public void addNode(T key, int val) {
		if (!nodeMap.containsKey(key)) {
			Node<T> node = new Node<T>(key, val);
			nodeMap.put(key, node);
			minHeap.offer(node);
		}
	}
	
	public void updateNode(T key,int val){
		nodeMap.get(key).val = Integer.MAX_VALUE;
		Node<T> node = new Node<T>(key,val);
		nodeMap.put(key, node);
		minHeap.offer(node);
	}
	
	public Node<T> removeMin(){
		if(minHeap.peek().val != Integer.MAX_VALUE){
			nodeMap.remove(minHeap.peek().key);
			Node<T> ret = minHeap.poll();
			if(nodeMap.isEmpty())
				minHeap.clear();
			return ret;
		}
		return null;
	}
	
	public int peek(){
		return minHeap.peek().val;
	}
	
	public boolean isEmpty(){
		return nodeMap.isEmpty();
	}
	
	public int getNodeVal(int i){
		return nodeMap.get(i).val;
	}
	
	public void removeFromList(T key){
		nodeMap.remove(key);
	}

	public boolean containsNode(int key) {
		// TODO Auto-generated method stub
		return nodeMap.containsKey(key);
	}
}
