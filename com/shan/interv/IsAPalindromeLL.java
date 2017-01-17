package com.shan.interv;

public class IsAPalindromeLL {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		
		System.out.println(isPalindrome(n1));
	}
	

    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        if(length == 0)
            return true;
        boolean even = length%2 == 0;
        length = length/2;
        
        temp = head;
        ListNode prev = null;
        ListNode nextN = temp.next;
        while(temp.next != null && length > 0){
            temp.next = prev;
            prev = temp;
            temp = nextN;
            nextN = temp.next;
            length--;
        }
        
        ListNode start1 = prev;
        ListNode start2;
        if(even){
            start2 = temp;
        }   else{
            start2 = nextN;
        }
        
        while(start1 != null && start2 != null){
            if(start1.val != start2.val)
                return false;
            else{
                start1 = start1.next;
                start2 = start2.next;
            }
        }
        
        return true;
    }


}
