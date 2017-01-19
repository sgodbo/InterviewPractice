package com.shan.dp;

public class LongestPalindromicSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public String LPS(String str,int i,int j){
		if(i == 0)
			return String.valueOf(str.charAt(i));
		StringBuffer lStr = new StringBuffer(LPS(str,0,i-1));
		StringBuffer rStr = new StringBuffer(LPS(str,i+1,2*i + 1));
		
		if(lStr == rStr.reverse())
			return lStr.append(str.charAt(i)).append(rStr).toString();
	}

}
