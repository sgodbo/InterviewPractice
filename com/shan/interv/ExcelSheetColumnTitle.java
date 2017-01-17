package com.shan.interv;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for(int i = 1;i <= 677;i++)
		//	System.out.println(i + "------>" + convertToTitle(i));
		System.out.println(Math.log(27)/Math.log(26));
	}

	public static String convertToTitle(int n) {

		char[] alphaArr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuffer sb = new StringBuffer();
		while (n > 0) {
			int rem = n % 26;
			if (rem > 0) {
				sb.append(alphaArr[rem - 1]);
				n = n-rem;
			} else {
				int k = (int) (Math.log(n) / Math.log(26));
				for(int i = 0;i < k;i++){
					sb.append("A");
				}
				n = (int) (n - Math.pow(26, k));
				n = n/26;
				if(n > 0)
					sb.append(alphaArr[n]);
				n = n/26;
			}
		}sb.repl
		return sb.reverse().toString();

	}

}
