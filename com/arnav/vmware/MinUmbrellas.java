package com.arnav.vmware;

/* Dynamic Programming Java implementation of Coin
 Change problem */
import java.util.Arrays;

public class MinUmbrellas {
	public static int minimumCoinBottomUp(int n, int umbrellas[]){
        int countUmbs[] = new int[n + 1];
        int R[] = new int[n + 1];
        countUmbs[0] = 0;
        for(int i=1; i <= n; i++){
            countUmbs[i] = Integer.MAX_VALUE;
        }
        for(int j=0; j < umbrellas.length; j++){
            for(int i=1; i <= n; i++){
                if(i >= umbrellas[j]){
                    if (countUmbs[i - umbrellas[j]] + 1 < countUmbs[i]) {
                        countUmbs[i] = 1 + countUmbs[i - umbrellas[j]];
                    }
                }
            }
        }
        
        if(countUmbs[n] == Integer.MAX_VALUE)
        	return -1;
        return countUmbs[n];
    }
	
	private static void printCoinCombination(int R[], int coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        //System.out.print("Coins used to form total ");
        while ( start != 0 ) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }

	// Driver Function to test above function
	public static void main(String args[]) {
		int umbrellaCount[] = {};
		int n = 4;
		
		System.out.println(minimumCoinBottomUp(n, umbrellaCount));
	}
}
// This code is contributed by Pankaj Kumar