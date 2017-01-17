package com.shan;

public class BuildTreeFromExpr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inOrder = "DBEAFC";
		String preOrder = "ABDECF";
		TreeNode result = BuildBinaryTree(preOrder.toCharArray(),0,preOrder.length()-1,inOrder.toCharArray(),0,inOrder.length()-1);
		
		while(result.getLeft() != null){
			System.out.println(result.getData());
			result = result.getLeft();
		}
	}

	private static TreeNode BuildBinaryTree(char[] charArray, int i, int j,
			char[] charArray2, int k, int l) {
		// TODO Auto-generated method stub
		if(k > l|| i > j)
			return null;
		char root = charArray[i];
		int m = 0;
		for(;m < charArray2.length;m++){
			if(charArray[i] == charArray2[m]){
				break;
			}
		}
		
		TreeNode t1 = new TreeNode(root);
		t1.setLeft(BuildBinaryTree(charArray, i+1, i+m, charArray2, k, k+m-1));
		t1.setRight(BuildBinaryTree(charArray, i+m+1, j, charArray2, m+1, l));
		
		return t1;
	}

}
