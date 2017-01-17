package com.shan.interv;

public class BulbSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bulbSwitch(9999999));
	}
	

    public static int bulbSwitch(int n) {
    	
        int[] arr = new int[n];
        
        
        int count = 0;
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j+=(i+1)){
                if(arr[j] == 0){
                    arr[j] = 1;
                    count++;
                }
                else{
                    arr[j] = 0;
                    count--;
                }
                    
            }
        }
        
        return count;
    }
    
    


}
