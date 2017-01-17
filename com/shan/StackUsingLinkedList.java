package com.shan;

public class StackUsingLinkedList extends SimpleLinkedList{
	private SimpleLinkedList s1;
	int length;
	StackUsingLinkedList(){
		length = 0;
	}
	
	public Node removeFromEnd(){
		throw new UnsupportedOperationException();
	}
	public void pushElement(int data){
		
		Node n1 = new Node();
		n1.setData(data);
		s1.insertNodeAtEnd(n1);
	}
	
	public Node popElement(){
		
		return s1.removeFromEnd();
	}
}
