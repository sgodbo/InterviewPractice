package com.shan.interv;
import java.util.*;
import java.util.regex.*;
public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "+1.2345E-2";
		int t = atoi(test);
		System.out.println(t);
	}

	private static int atoi(String test) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("^([+-]{0,1})([0-9]*.[0-9]+)([E][+-]+[0-9]+)$");
		Matcher m = p.matcher(test);

        int num = 0;
		while(m.find()){
			int gC = m.groupCount();
			if(gC )
			int posNegFactor = 1;
			if(m.group(1).toString().equals("-"))
				posNegFactor = -1;
			
			if(!m.group(3).toString().isEmpty()){
				
			}
				posNegFactor = posNegFactor * Math.pow(10, )
			char[] strArr = test.toCharArray();
	        int k = 0;
	        for(int i = strArr.length-1;i >= 0;i--){
	            num += (strArr[i]-48)*Math.pow(10,k);
	            k++;
	        }
		}
		
		return num;
	}

}
