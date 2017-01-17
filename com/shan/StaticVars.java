package com.shan;

import java.util.Scanner;

public class StaticVars {

	private static int B;
    private static int H;
    private static boolean flag;

    static {
        Scanner in = new Scanner(System.in);
        int b = in.nextInt();
        int h = in.nextInt();
        if(b <= 0 || h <= 0){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            flag = false;
        }   else{
            B = b;H = h;
            flag = true;
        }
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(flag){
			int area = B*H;
			System.out.println(area);
		}
	}

}
