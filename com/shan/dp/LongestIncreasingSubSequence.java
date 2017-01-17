package com.shan.dp;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {10,22,9,33,21,50,41,60,80};
		int arr[] = {3,4,-1,0,6,2,3};
		int dup[] = new int[arr.length];
		for(int i = 0;i < dup.length;i++)
			dup[i] = 1;
		
		int max = Integer.MIN_VALUE;
		for(int i = 1;i < dup.length;i++){
			for(int j = 0;j < i;j++){
				if(arr[j] < arr[i] && dup[j]+1 > dup[i]){
					dup[i] = dup[j]+1;
					if(max < dup[i])
						max = dup[i];
				}
			}
		}
		
		System.out.println(max);
	}

}
