package com.shan.dp;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {40,20,30,10,30};
		System.out.println(matrixChainRec(arr,0,4,4));
	}

	private static int matrixChainRec(int[] arr, int i, int j, int k) {
		// TODO Auto-generated method stub
		if(j-i == 1)
			return arr[i]*arr[j];
		int left = matrixChainRec(arr, i, j-1, j)*arr[j];
		int right = matrixChainRec(arr, i+1, j, i)*arr[i];
		
		return Math.min(left, right);
	}

}
