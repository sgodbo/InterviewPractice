package com.shan.graph;

import java.util.*;
public class Test1 {
	static class haha{
		int key;
		int val;
	}
	public static void main(String[] args){
		//ArrayList<Integer> stk = new ArrayList<Integer>();
		haha stk = new haha();
		stk.val = 0;
		//System.out.println(stk);
		fact(stk,0);
		
		/*while(!stk.isEmpty()){
			System.out.println(stk.pop());
		}
		System.out.println();*/
	}
	
	public static void fact(haha stk,int n){
		if(n == 10)
			return;
		
		System.out.println(stk);
		stk.val = n++;
		fact(stk,n);
	}
}
