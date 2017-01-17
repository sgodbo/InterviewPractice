package com.shan.interv;

public class RightRotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2};
		rotate(nums, 1);
	}

	public static void rotate(int[] nums, int k) {
		int actualRot = k % nums.length;
		int[] newArr = rotateByReturningCopiedShiftedArr(nums, actualRot);Math.floor(Math.log10(k));
	}

	public static int[] rotateByShift(int[] nums, int k) {
		while (k-- > 0) {
			int prev = nums[0];
			for (int i = 1; i < nums.length; i++) {
				int temp2 = nums[i];
				nums[i] = prev;
				prev = temp2;
			}
			nums[0] = prev;
		}

		return nums;
	}

	public static int[] rotateByReturningCopiedShiftedArr(int[] nums, int k) {
		int[] newArr = new int[nums.length];
		int[] tempRotArr = new int[k];
		System.arraycopy(nums, 0, newArr, k, nums.length - k);
		System.arraycopy(nums, nums.length - k, tempRotArr, 0, k);
		System.arraycopy(tempRotArr, 0, newArr, 0, k);
		return newArr;
	}

	private static int[] reverseArray(int[] tempRotArr) {
		// TODO Auto-generated method stub
		int l = tempRotArr.length;
		int end = 0;
		if (l % 2 == 0)
			end = (l - 1) / 2;
		else
			end = l / 2 - 1;
		for (int i = 0; i <= end; i++) {
			int temp = tempRotArr[i];
			tempRotArr[i] = tempRotArr[tempRotArr.length - 1 - i];
			tempRotArr[tempRotArr.length - 1 - i] = temp;
		}
		return tempRotArr;
	}

}
