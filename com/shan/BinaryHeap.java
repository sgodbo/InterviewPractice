package com.shan;

import java.util.HashSet;
import java.util.TreeSet;

public class BinaryHeap {
	int[] arr;
	int countEle;
	int size;

	public BinaryHeap() {
		arr = new int[10];
		this.size = 10;
		this.countEle = 0;
	}

	public BinaryHeap(int n) {
		this.arr = new int[n];
		this.size = n;
		this.countEle = 0;
	}

	public int getParent(int i) {
		if (i == 0) {
			return -1;
		} else {
			return (i - 1) / 2;
		}
	}

	public void insertElement(int e) {
		if (this.countEle < this.size) {
			arr[this.countEle] = e;
			int parent;
			while ((parent = getParent(this.countEle)) < e) {
				int temp = arr[parent];
				arr[parent] = e;
				arr[this.countEle] = temp;
			}
			this.countEle++;
		} else {
			HashSet<Integer> ts = new HashSet<Integer>();
			
			int[] arrTemp = arr;
			this.size *= 2;
			int[] arr = new int[this.size];
			for (int i = 0; i < arrTemp.length; i++) {
				arr[i] = arrTemp[i];
				arrTemp[i] = Integer.MIN_VALUE;
			}
		}
	}

	public int deleteElement(int e) {
		return 0;
	}
}
