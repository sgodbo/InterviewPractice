package com.shan;

import java.util.*;
import java.util.Map;

public class SimpleLinkedList {
	Node head;
	Map<Integer,Integer> posMap;
	public void insertNodeAtStart(Node n1) {
		posMap = new HashMap<Integer,Integer>();
		n1.setNext(head);
		this.head = n1;
		length++;
		
	}
	
	public void insertInSorted(Node n1){
		Node temp = head;
		while(temp.getNext() != null){
			if(temp.getData() < n1.getData() && temp.getNext().getData() > n1.getData()){
				n1.setNext(temp.getNext());
				temp.setNext(n1);
				break;
			}
			temp = temp.getNext();
		}
	}
	
	public void reverseList(){
		Node temp = head;
		Node prev = null;
		while(temp.getNext() != null){
			prev = temp;
			temp = temp.getNext();
		}
		while(temp != head){
			temp.setNext(prev);
			temp = prev;
		}
		temp.setNext(null);
		
	}

	public void insertNodeAtEnd(Node n1) {
		if (head == null)
			head = n1;
		else {
			Node temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			
			temp.setNext(n1);
			n1.setNext(null);
			length++;
		}
	}

	public void insertNodeAtPosition(int pos, Node n1) {
		if (pos < 0) {
			pos = 0;
		} else if (pos > length) {
			pos = length;
		}

		if (head == null)
			head = n1;
		else if (pos == 0) {
			n1.setNext(head);
			this.head = n1;
			length++;
		} else {
			Node temp = head;
			for (int i = 1; i < pos; i++) {
				temp = temp.getNext();
			}
			n1.setNext(temp.getNext());
			temp.setNext(n1);

			length++;
		}
	}

	public Node removeFromEnd() {
		Node temp = head;
		Node prev = null;
		if (head == null)
			return null;
		else if (head.getNext() == null) {
			return head;
		} else {
			while (temp.getNext() != null) {
				prev = temp;
				temp = temp.getNext();
			}

			prev.setNext(null);
			length--;
			return temp;
		}
	}

	public Node removeFromStart() {
		Node temp = head;
		temp.setNext(null);
		head = head.getNext();
		length--;
		return temp;
	}
	
	public Node removeAtPos(int pos){
		Node temp = head;
		Node prev = null;
		if(pos <= 0){
			removeFromStart();
		}	else if(pos > length){
			removeFromEnd();
		}
		for(int i = 1;i < pos;i++){
			prev = temp;
			temp = temp.getNext();
		}
		
		prev.setNext(temp.getNext());
		temp.setNext(null);
		
		return temp;
	}
	
	public void checkForLoops(){
		Node temp = head;
		while(temp.getNext() != null){
			temp = temp.getNext();
		}
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	private int length;

	public SimpleLinkedList() {
		length = 0;
	}
}
