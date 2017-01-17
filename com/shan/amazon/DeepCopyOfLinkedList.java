package com.shan.amazon;

public class DeepCopyOfLinkedList {
	static class ListNode{
		int data;
		ListNode next;
		ListNode arb;
		
		public ListNode(int d){
			data = d;
			next = null;
			arb = null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		ListNode head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		n1.arb = n3;
		n2.arb = n1;
		n3.arb = n5;
		n4.arb = n3;
		n5.arb = n2;
		
		ListNode newHead = getDeepCopyOfLinkedList(head);
		while(newHead != null){
			System.out.println(newHead.data + " " + newHead.next.data + " " + newHead.arb.data);
			newHead = newHead.next;
		}
	}
	
	public static ListNode getDeepCopyOfLinkedList(ListNode head){
		ListNode temp = head;
		ListNode newHead = null;
		while(temp != null){
			ListNode copyNode = new ListNode(temp.data);
			copyNode.next = temp.next;
			temp.next = copyNode;
			temp = temp.next.next;
		}
		
		temp = head;
		while(temp != null){
			temp.next.arb = temp.arb.next;
			temp = temp.next.next;
		}
		
		temp = head;
		while(temp != null){			
			ListNode copyNode = temp.next;
			if(newHead == null)
				newHead = copyNode;
			temp.next = temp.next.next;
			if(temp.next == null)
				copyNode.next = null;
			else
				copyNode.next = copyNode.next.next;
			temp = temp.next;
		}
		
		return newHead;
	}

}
