package com.shan.dp;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "abcdefgh";
		String y = "atryuibjklcqwrif";
		
		System.out.println(editDistDp(x,y,x.length(),y.length()));
		System.out.println(editDistDpSpaceEff(x,y,x.length(),y.length()));
	}
	
	public static int editDist(String x,String y,int m,int n){
		if(m == 0)
			return n;
		if(n == 0)
			return m;
		if(x.charAt(m-1) == y.charAt(n-1))
			return editDist(x, y, m-1, n-1);
		
		return 1 + Math.min(editDist(x, y, m-1, n-1), Math.min(editDist(x, y, m-1, n), editDist(x, y, m, n-1)));
	}
	
	public static int editDistDp(String x,String y,int m,int n){
		int[][] dpArr = new int[m+1][n+1];
		for(int i = 0;i <= m;i++){
			for(int j = 0;j <= n;j++){
				if(i == 0)
					dpArr[i][j] = j;
				else if(j == 0)
					dpArr[i][j] = i;
				else if(x.charAt(i-1) == y.charAt(j-1))
					dpArr[i][j] = 1 + dpArr[i-1][j-1];
				else
					dpArr[i][j] = Math.max(dpArr[i-1][j-1], Math.max(dpArr[i-1][j], dpArr[i][j-1]));
			}
		}
		
		return dpArr[m][n];
	}
	
	public static int editDistDpSpaceEff(String x,String y,int m,int n){
		int[][] dpArr = new int[2][n+1];
		
		int rowIdx = 0;
		for(int i = 0;i <= m;i++){
			rowIdx = i%2;
			for(int j = 0;j <= n;j++){
				if(i == 0)
					dpArr[rowIdx][j] = j;
				else if(j == 0)
					dpArr[rowIdx][j] = i;
				else if(x.charAt(i-1) == y.charAt(j-1))
					dpArr[rowIdx][j] = 1 + dpArr[1-rowIdx][j-1];
				else
					dpArr[rowIdx][j] = Math.max(dpArr[1-rowIdx][j-1], Math.max(dpArr[1-rowIdx][j], dpArr[rowIdx][j-1]));
			}
		}
		
		return dpArr[rowIdx][n];
	}

}
