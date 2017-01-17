package com.shan.amazon;

public class IsRectangleIntersecting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coords = {-3,0,3,4,-4,-1,0,2};
		System.out.println(isRectIntersecting(coords));
	}
	
	public static boolean isRectIntersecting(int[] arr){
		int A = arr[0];
		int B = arr[1];
		int C = arr[2];
		int D = arr[3];
		int E = arr[4];
		int F = arr[5];
		int G = arr[6];
		int H = arr[7];
		
		if((C > E && D > F) && (A < G && B < H))
			return true;
		return false;
	}

}
