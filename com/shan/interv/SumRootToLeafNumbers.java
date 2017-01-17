package com.shan.interv;


public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t = new TreeNode(8);
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(9);
		TreeNode t4 = new TreeNode(9);
		TreeNode t5 = new TreeNode(5);
		t.left = t1;
		t.right = t2;
		
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		sumNumbers(t);
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public static int sumNumbers(TreeNode root) {
        String[] paths = pathsRec(root).split("\\|");
        int sum = 0;
        for(String path:paths){
            System.out.println(path);
            if(!path.equals(""))
                sum += Integer.parseInt(path);
        }
        
        return sum;
    }
    
    public static String pathsRec(TreeNode root){
        if(root == null)
            return "";
        String rval = String.valueOf(root.val);
        String left = pathsRec(root.left);
        String right = pathsRec(root.right);
        if(left.isEmpty() && right.isEmpty())
            return rval;
        if(left.isEmpty())
            return concatAll(rval,right);
        if(right.isEmpty())
            return concatAll(rval,left);    
        return (concatAll(rval,left) + "|" + concatAll(rval,right)); 
    }

	private static String concatAll(String rval, String path) {
		// TODO Auto-generated method stub
		String[] innerPaths = path.split("\\|");
		StringBuffer totalNum = new StringBuffer();
		for(String p:innerPaths){
			totalNum.append(rval);
			totalNum.append(p);
			totalNum.append("|");
		}
		totalNum.replace(totalNum.length()-1, totalNum.length(), "");
		return totalNum.toString();
	}


}
