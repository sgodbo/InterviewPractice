package com.shan.dp;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		String x = "abcdefgh";
		String y = "atryuibjklcqwrif";
		long time = System.currentTimeMillis();
		//System.out.println(lcs(x,y,x.length(),y.length()));
		//System.out.println(lcsDp(x,y,x.length(),y.length()));
		System.out.println(lcsDPEffSpace(x,y,x.length(),y.length()));
		System.out.println(System.currentTimeMillis() - time);
	}
	
	public static int lcs(String x,String y,int m,int n){
		if(m == 0 || n == 0)
			return 0;
		if(x.charAt(m-1) == y.charAt(n-1))
			return 1 + lcs(x,y,m-1,n-1);
		return Math.max(lcs(x,y,m-1,n), lcs(x,y,m,n-1));
	}
	
	public static int lcsDp(String x,String y,int m,int n){
		int[][] dpArr = new int[m+1][n+1];
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i <= m;i++){
			for(int j = 0;j <= n;j++){
				if(i == 0 || j == 0)
					dpArr[i][j] = 0;
				else if(x.charAt(i-1) == y.charAt(j-1)){
					dpArr[i][j] = 1 + dpArr[i-1][j-1];
					sb.append(x.charAt(i-1));
				}					
				else
					dpArr[i][j] = Math.max(dpArr[i-1][j], dpArr[i][j-1]);
			}
		}
		
		System.out.println(sb.toString());
		return dpArr[m][n];
	}
	
	public static int lcsDPEffSpace(String x,String y,int m,int n){
		int[][] dpArr= new int[2][n+1];
		StringBuffer sb = new StringBuffer();
		
		int rowIdx = 0;
		for(int i = 0;i <= m;i++){
			rowIdx = i%2;
			for(int j = 0;j <= n;j++){
				if(i == 0 || j == 0)
					dpArr[rowIdx][j] = 0;
				else if(x.charAt(i-1) == y.charAt(j-1)){
					dpArr[rowIdx][j] = 1 + dpArr[1-(rowIdx)][j-1];
					sb.append(x.charAt(i-1));
				}					
				else
					dpArr[rowIdx][j] = Math.max(dpArr[rowIdx][j-1],dpArr[1-(rowIdx)][j]);
			}
		}
		
		System.out.println(sb.toString());
		return dpArr[rowIdx][n];
	}

}
