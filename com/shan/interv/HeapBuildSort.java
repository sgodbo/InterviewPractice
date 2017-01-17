package com.shan.interv;

public class HeapBuildSort {

	private int[] array;
	private int capacity;
	private int count;
	private boolean heap_type;	// true for max heap and false for min heap
	
	public HeapBuildSort(int capacity, boolean heap_type){
		this.array = new int[capacity];
		this.capacity = capacity;
		this.heap_type = heap_type;
		this.count = 0;
	}
	
	public int getParent(int childIdx){
		if(childIdx <= 0 || childIdx >= capacity)
			return Integer.MIN_VALUE;
		return (childIdx-1)/2;
	}
	
	public int getLeftChild(int parentIdx){
		int leftChildIdx = 2*parentIdx + 1;
		if(leftChildIdx >= capacity)
			return Integer.MIN_VALUE;
		return leftChildIdx;
	}
	
	public int getRightChild(int parentIdx){
		int rightChildIdx = 2*parentIdx + 1;
		if(rightChildIdx >= capacity)
			return Integer.MIN_VALUE;
		return rightChildIdx;
	}
	
	public int getMaximum(){
		if(this.heap_type)
			return this.array[0];
		return Integer.MIN_VALUE;
	}
	
	public int getMinimum(){
		if(!this.heap_type)
			return this.array[0];
		return Integer.MIN_VALUE;
	}
	
	public int deleteMax(){
		if(this.heap_type){
			int data = getMaximum();
			swap(0, count-1);
			percolateDown(0);
			return data;
		}
		return Integer.MIN_VALUE;			
	}
	
	public int deleteMin(){
		if(!this.heap_type){
			int data = getMinimum();
			swap(0, count-1);
			percolateDown(0);
			return data;
		}
		return Integer.MIN_VALUE;
	}
	
	public void insert(int data){
		if(count == capacity)
			resizeHeap();
		this.count++;
		this.array[count] = data;
		int i = count-1;
		for(;i >= 0 && compareParentChild(i, count-1);i--){
			swap(i, count-1);
		}
		this.array[i] = data;
	}
	
	private boolean compareParentChild(int i, int count2) {
		// TODO Auto-generated method stub
		if(this.heap_type)
			return this.array[i] > this.array[count2];
		else
			return this.array[i] < this.array[count2];
	}

	private void resizeHeap() {
		// TODO Auto-generated method stub
		int[] resizedArr = new int[2*capacity];
		System.arraycopy(this.array, 0, resizedArr, 0, this.count);
		this.array = resizedArr;
	}

	public void percolateDown(int pos){
		if(this.heap_type){
			int l = getLeftChild(pos);
			int r = getRightChild(pos);
			
			if(this.array[pos] > this.array[l] && this.array[pos] > this.array[r]){
				// Do nothing
			}	else{
				int max = l > r ? l : r;
				swap(pos, max);
				percolateDown(max);
			}				
		}	else{
			int l = getLeftChild(pos);
			int r = getRightChild(pos);
			
			if(this.array[pos] < this.array[l] && this.array[pos] < this.array[r]){
				// Do nothing
			}	else{
				int min = l < r ? l : r;
				swap(pos, min);
				percolateDown(min);
			}
		}
	}
		
	
	
	private void swap(int pos1, int pos2) {
		// TODO Auto-generated method stub
		int temp = this.array[pos1];
		this.array[pos1] = this.array[pos2];
		this.array[pos2] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
