package com.shan.interv;

public class SetMatrixZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,0,2,3},{2,3,4,5},{Integer.MIN_VALUE, Integer.MAX_VALUE, 6, 0}};
		setZeroes(matrix);
	}
	

    public static void setZeroes(int[][] matrix) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < matrix.length;i++){
        	sb.append("1");
        	for(int j = 0;j < matrix[0].length;j++){
            	sb.append("1");
            }
        }       
        
        
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    sb.replace(2*i,2*i+1,"0");
                    sb.replace(2*j+1,2*j+2,"0");
                }
            }
        }
        
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == Integer.MIN_VALUE)
                    matrix[i][j] = 0;
            }
        }
    }


}
