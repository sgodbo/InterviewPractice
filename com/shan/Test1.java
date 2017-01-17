package com.shan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Test1 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Stack<Integer> stBin = new Stack<Integer>();
        int tempR = 0;
        int maxCont = 0;
        int runSum = 0;
        while(n > 0){
            tempR = n%2;
            if(tempR == 1){
                runSum++;
                if(!stBin.isEmpty() && stBin.peek() == 0)
                    --runSum;
                if(runSum > maxCont){
                	maxCont = runSum;
                }
            }   else{
                runSum = 0;
            }
            n = n/2;
        }
        
        System.out.println(maxCont);
    }

	static int maxDifference(int[] arr) {
		int max_diff = arr[1] - arr[0];
		int min = arr[0];
		int i;
		for (i = 1; i < arr.length; i++) {
			if (arr[i] - min > max_diff)
				max_diff = arr[i] - min;
			if (arr[i] < min)
				min = arr[i];
		}

		return max_diff;
	}
}
