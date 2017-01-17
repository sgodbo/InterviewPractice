package com.shan;

public class Node {
	private int data;
	private Node next;
	
	public Node(){
		next = null;
		data = Integer.MIN_VALUE;
	}
	
	public Node(int data){
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
