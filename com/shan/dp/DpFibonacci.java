package com.shan.dp;
import java.util.*;
public class DpFibonacci {

	static Map<Integer,Integer> fibNums;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fibNums = new HashMap<Integer,Integer>();
		System.out.println(fib(7));
	}
	
	public static int fib(int n){
		if(n <= 1){
			fibNums.put(n,n);
			return n;
		}
		int sum = 0;
		if(fibNums.containsKey(n-1))
			sum += fibNums.get(n-1);
		else
			sum += fib(n-1);
		if(fibNums.containsKey(n-2))
			sum += fibNums.get(n-2);
		else
			sum += fib(n-2);
		fibNums.put(n,sum);
		return sum; 
	}

}
