package com.shan.interv;



public class ReverseLinkedListStartEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		reverseBetween(n1,1,2);
	
	}
	

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode temp = head;
        int idx = 1;
        ListNode prev = null;
        while(temp != null && idx < m){
        	prev = temp;
            temp = temp.next;
            idx++;
        }
        if(idx < m)
            return head;
        ListNode start = temp;
        int len = m - n;
		ListNode curr = start;
		if (head == null)
			return null;
		
		ListNode next = curr.next;
		while (next != null && len > 0) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = curr.next;
			len--;
		}
		if(curr != head)
			curr.next = prev;
		
		return curr;
	
        return head;
    }
    
    public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
    


}
