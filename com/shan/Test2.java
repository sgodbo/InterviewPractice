package com.shan;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String text  = "";
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile("(http://[a-z.]*)");
		Matcher m;
		while((text = in.next()) != null){
			m = p.matcher(text);
			while(m.find()){
				System.out.println(m.group(0));
			}
		}
		
	}

}
