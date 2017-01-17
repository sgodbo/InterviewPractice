package com.shan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ResetRowColOnZero{

	public static void removeDuplicates(int[] arr){
	    Set<Integer> repeatEle = new TreeSet<Integer>();
	    for(int i = 0;i < arr.length;i++){
	        if(repeatEle.contains(arr[i])){
	            arr[i] = Integer.MIN_VALUE;
	        }    else{
	            repeatEle.add(arr[i]);
	        }
	    }
	    Set<Integer> st = new HashSet<Integer>();
	    
	    for(int i = 0;i < arr.length;i++){
	    	if(arr[i] != Integer.MIN_VALUE){
	    		System.out.println(arr[i]);
	    	}
	    }
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	}
    public static void main(String[] args){
        int[][] arr = new int[3][3];
        arr[0][0] = 5;
        arr[0][1] = 1;
        arr[0][2] = 2;
        arr[1][0] = 3;
        arr[1][1] = 4;
        arr[1][2] = 0;
        arr[2][0] = 6;
        arr[2][1] = 7;
        arr[2][2] = 0;
        
        String s1 = "erbottlewat";
        String s2 = "waterbottle";
        
        int[] arr2 = {0,1,2,5,0,5,6,10,3};
        removeDuplicates(arr2);
        int sum = 0;
        
        sum += 3*Math.pow(10,4);
        List<Integer> indices = new ArrayList<Integer>();
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                if(arr[i][j] == 0){
                    indices.add(i);
                    indices.add(j);
                    break;
                }
            }
        }
        
        for(int i = 0;i < indices.size();i++){
        
            if(i%2 == 0){
            	for(int k = 0;k < 3;k++){
                    arr[indices.get(i)][k] = 0;
                }
            }    else{
                for(int k = 0;k < 3;k++){
                    arr[k][indices.get(i)] = 0;
                }
            }
            
        }
        
        for(int i = 0;i < 3;i++){
        	for(int j = 0;j < 3;j++){
        		System.out.print(arr[i][j]);
        	}
        	System.out.println();
        }
    }
}
