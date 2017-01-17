package com.shan.interv;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse(-2147483648);
		System.out.println(Integer.MAX_VALUE);
	}
	
	public static int reverse(int x) {
        if(x <= Integer.MIN_VALUE)
            return 0;
        int factor = 1;
        if(x < 0){
            factor = -1;
            x = -1*x;
        }
            
        int k = (int) Math.floor(Math.log10(x));
        int newNum = 0;
        while(x/10 != 0){
            newNum += (x%10)*Math.pow(10,k);
            x = x/10;
            k--;
        }
        
        newNum += (x%10)*Math.pow(10,k);
        
        if(newNum >= Integer.MAX_VALUE)
            return 0;
        
        newNum = factor * newNum;
        return newNum;
    }

}
