package com.shan.dp;

public class CoinChanging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int S[] = {1,2,3};
		int n = 4;
		
		System.out.println(coinChangingDp(S, S.length, n));
	}
	
	public static int coinChanging(int[] S,int m,int n){
		if(n == 0)
			return 1;
		if(n < 0)
			return 0;
		if(m <= 0 && n > 0)
			return 0;
		return coinChanging(S,m-1,n) + coinChanging(S,m,n-S[m-1]);
	}
	
	public static int coinChangingDp(int[] S,int m,int n){
		int[] dpArr = new int[n+1];
		dpArr[0] = 1;
		for(int i = 0;i < m;i++){
			for(int j = S[i];j <= n;j++){
				dpArr[j] += dpArr[j-S[i]];
			}
		}
		
		return dpArr[n];
	}

}
