package com.shan;

import java.util.*;
import java.util.Map.Entry;

public class ChineseRemainderTheorem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,10,11,13};
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		int[][] list = new int[990][4];
		for(int i = 0;i < 990;i++){
			int[] temp = new int[4];
			for(int j = 0;j < 4;j++){
				int N = sum(arr,j);
				list[i][j] = i%arr[j] + N;
			}
		}
		System.out.println(list.length);
		int maxIntersect = 0;
		for(int i = 0;i < 989;i++){
			int[] arr1 = list[i];
			int[] arr2 = list[i+1];
			int intersect = 0;
			for(int j = 0;j < 4;j++){
				for(int k = 0;k < 4;k++){
					if(arr1[j] == arr[k]){
						intersect++;
					}
				}
				
			}
			if(maxIntersect < intersect){
				maxIntersect = intersect;
			}
		}
		System.out.println(maxIntersect);
	}

	private static int sum(int[] arr, int i) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int j = 0;j < i;j++){
			sum += arr[i];
		}
		return sum;
	}

}
