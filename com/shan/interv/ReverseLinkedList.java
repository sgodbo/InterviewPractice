package com.shan.interv;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		reverseList(n1);
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode reverseList(ListNode head) {
		ListNode curr = head;
		if (head == null)
			return null;
		ListNode prev = null;
		ListNode next = curr.next;

		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if(next != null)
				next = curr.next;
		}

		return prev;
	}
}
