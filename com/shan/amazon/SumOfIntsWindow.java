package com.shan.amazon;

public class SumOfIntsWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int window = 3;
		int[] res = sumOfAllWindows(arr, window);
		for(int num:res){
			System.out.println(num);
		}
		System.out.println();
	}

	public static int[] sumOfAllWindows(int[] arr, int w) {
		int[] sums = new int[arr.length-w+1];
		for(int i = 0;i < w;i++){
			sums[0] += arr[i];
		}
		for(int i = 1;i < sums.length;i++){
			sums[i] = sums[i-1] - arr[i-1] + arr[w+i-1];
		}
		return sums;
	}

}
