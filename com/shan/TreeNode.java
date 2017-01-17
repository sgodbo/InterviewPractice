package com.shan;

public class TreeNode {

	TreeNode left;
	TreeNode right;
	int data;
	char dataC;
	public TreeNode(){
		this.data = 0;
		this.left = null;
		this.right = null;
	}
	public TreeNode(int num){
		this.data = num;
		this.left = null;
		this.right = null;
	}
	public TreeNode(char num){
		this.dataC = num;
		this.left = null;
		this.right = null;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public char getDataC() {
		return this.dataC;
	}
	public void setDataC(char c) {
		this.dataC = c;
	}
}
