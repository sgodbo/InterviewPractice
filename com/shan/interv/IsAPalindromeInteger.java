package com.shan.interv;

public class IsAPalindromeInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(9999));
	}
	


    public static boolean isPalindrome(int x) {
        if(x == Integer.MIN_VALUE || x < 0)
            return false;
        int tempN = x;
        int length = 0;
        while(tempN > 0){
            tempN = tempN/10;
            length++;
        }
        if(length == 1)
            return true;
        boolean even = length%2 == 0;
        int mid = length/2;
        tempN = x;
        while(mid > 0){
            int num1 = tempN/(int)Math.pow(10, length-1);
            int num2 = tempN%10;
            if(num1 != num2)
                return false;
            else{
                tempN = tempN%(int)Math.pow(10, length-1);
                tempN = tempN/10;
                length-=2;
                mid--;
            }
        }
        
        return true;
    }



}
