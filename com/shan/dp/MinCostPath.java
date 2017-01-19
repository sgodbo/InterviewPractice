package com.shan.dp;

public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,8,2},{1,5,3}};
		System.out.println(minCostPath(matrix, 0, 0));
		System.out.println(minCostPathDp(matrix));
	}
	
	public static int minCostPath(int[][] matrix,int i,int j){
		if(i == matrix.length-1 && j == matrix[0].length-1){
			return matrix[i][j];
		}
		int diag = 0;
		int side = 0;
		int below = 0;
		if(i == matrix.length -1){
			diag = Integer.MAX_VALUE;
			below = Integer.MAX_VALUE;
			side = minCostPath(matrix,i,j+1);
		}	else if(j == matrix[0].length-1){
			diag = Integer.MAX_VALUE;
			side = Integer.MAX_VALUE;
			below = minCostPath(matrix, i+1, j);
		}	else{
			diag = minCostPath(matrix, i+1, j+1);
			below = minCostPath(matrix, i+1, j);
			side = minCostPath(matrix,i,j+1);
		}
		
		return Math.min(diag, Math.min(side, below))+matrix[i][j];		
	}
	
	public static int minCostPathDp(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dpArr = new int[m][n];
		for(int i = m-1;i >= 0;i--){
			for(int j = n-1;j >= 0;j--){
				if(i == m-1 && j == n-1)
					matrix[i][j] = matrix[i][j];
				else if(i == m-1){
					matrix[i][j] = matrix[i][j+1] + matrix[i][j];
				}	else if(j == n-1){
					matrix[i][j] = matrix[i+1][j] + matrix[i][j];
				}	else{
					matrix[i][j] = Math.min(matrix[i+1][j], Math.min(matrix[i+1][j+1],matrix[i][j+1])) + matrix[i][j];
				}
			}
		}
		
		return matrix[0][0];
	}
	
}
