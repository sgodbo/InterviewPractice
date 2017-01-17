package com.shan;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

class Solution {

	public static void main(String[] args) {
		int[] arr = { 2, 0, 0 };
		// int[] arr =
		// {1,7,7,4,3,1,7,0,1,4,4,9,2,8,5,0,0,9,3,1,2,5,9,6,0,9,9,0,9,6,0,5,3,7,9,8,8,9,8,2,5,4,1,9,3,8,0,5,9,5,6,1,1,8,9,3,7,8,5,8,5,5,3,0,4,3,1,5,4,1,7,9,6,8,8,9,8,0,6,7,8,3,1,1,1,0,6,8,1,1,6,6,9,1,8,5,6,9,0,0,1,7,1,7,7,2,8,5,4,4,5,2,9,6,5,0,8,1,0,9,5,8,7,6,0,6,1,8,7,2,9,8,1,0,7,9,4,7,6,9,2,3,1,3,9,9,6,8,0,8,9,7,7,7,3,9,5,5,7,4,9,8,3,0,1,2,1,5,0,8,4,4,3,8,9,3,7,5,3,9,4,4,9,3,3,2,4,8,9,3,3,8,2,8,1,3,2,2,8,4,2,5,0,6,3,0,9,0,5,4,1,1,8,0,4,2,5,8,2,4,2,7,5,4,7,6,9,0,8,9,6,1,4,7,7,9,7,8,1,4,4,3,6,4,5,2,6,0,1,1,5,3,8,0,9,8,8,0,0,6,1,6,9,6,5,8,7,4,8,9,9,2,4,7,7,9,9,5,2,2,6,9,7,7,9,8,5,9,8,5,5,0,3,5,8,9,5,7,3,4,6,4,6,2,3,5,2,3,1,4,5,9,3,3,6,4,1,3,3,2,0,0,4,4,7,2,3,3,9,8,7,8,5,5,0,8,3,4,1,4,0,9,5,5,4,4,9,7,7,4,1,8,7,5,2,4,9,7,9,1,7,8,9,2,4,1,1,7,6,4,3,6,5,0,2,1,4,3,9,2,0,0,2,9,8,4,5,7,3,5,8,2,3,9,5,9,1,8,8,9,2,3,7,0,4,1,1,8,7,0,2,7,3,4,6,1,0,3,8,5,8,9,8,4,8,3,5,1,1,4,2,5,9,0,5,3,1,7,4,8,9,6,7,2,3,5,5,3,9,6,9,9,5,7,3,5,2,9,9,5,5,1,0,6,3,8,0,5,5,6,5,6,4,5,1,7,0,6,3,9,4,4,9,1,3,4,7,7,5,8,2,0,9,2,7,3,0,9,0,7,7,7,4,1,2,5,1,3,3,6,4,8,2,5,9,5,0,8,2,5,6,4,8,8,8,7,3,1,8,5,0,5,2,4,8,5,1,1,0,7,9,6,5,1,2,6,6,4,7,0,9,5,6,9,3,7,8,8,8,6,5,8,3,8,5,4,5,8,5,7,5,7,3,2,8,7,1,7,1,8,7,3,3,6,2,9,3,3,9,3,1,5,1,5,5,8,1,2,7,8,9,2,5,4,5,4,2,6,1,3,6,0,6,9,6,1,0,1,4,0,4,5,5,8,2,2,6,3,4,3,4,3,8,9,7,5,5,9,1,8,5,9,9,1,8,7,2,1,1,8,1,5,6,8,5,8,0,2,4,4,7,8,9,5,9,8,0,5,0,3,5,5,2,6,8,3,4,1,4,7,1,7,2,7,5,8,8,7,2,2,3,9,2,2,7,3,2,9,0,2,3,6,9,7,2,8,0,8,1,6,5,2,3,0,2,0,0,0,9,2,2,2,3,6,6,0,9,1,0,0,3,5,8,3,2,0,3,5,1,4,1,6,8,7,6,0,9,8,0,1,0,4,5,6,0,2,8,2,5,0,2,8,5,2,3,0,2,6,7,3,0,0,2,1,9,0,1,9,9,2,0,1,6,7,7,9,9,6,1,4,8,5,5,6,7,0,6,1,7,3,5,9,3,9,0,5,9,2,4,8,6,6,2,2,3,9,3,5,7,4,1,6,9,8,2,6,9,0,0,8,5,7,7,0,6,0,5,7,4,9,6,0,7,8,4,3,9,8,8,7,4,1,5,6,0,9,4,1,9,4,9,4,1,8,6,7,8,2,5,2,3,3,4,3,3,1,6,4,1,6,1,5,7,8,1,9,7,6,0,8,0,1,4,4,0,1,1,8,3,8,3,8,3,9,1,6,0,7,1,3,3,4,9,3,5,2,4,2,0,7,3,3,8,7,7,8,8,0,9,3,1,2,2,4,3,3,3,6,1,6,9,6,2,0,1,7,5,6,2,5,3,5,0,3,2,7,2,3,0,3,6,1,7,8,7,0,4,0,6,7,6,6,3,9,8,5,8,3,3,0,9,6,7,1,9,2,1,3,5,1,6,3,4,3,4,1,6,8,4,2,5};
		// System.out.println(superPow(2147483647, arr));
		// System.out.println(myPow(-13.62608, 3));
		// int[] nums1 = {1,7,11}, nums2 = {2,4,6};
		 Scanner scan = new Scanner(System.in);
	        double mealCost = scan.nextDouble(); // original meal price
	        double tipPercent = scan.nextInt(); // tip percentage
	        double taxPercent = scan.nextInt(); // tax percentage
	        scan.close();
	      
	        // Write your calculation code here.
	        double amtAfterTipAndTax = mealCost * (double)(1 + tipPercent/100 + taxPercent/100);
	        // cast the result of the rounding operation to an int and save it as totalCost 
	        int totalCost = (int) Math.round(amtAfterTipAndTax);
	      
	        // Print your result
	        System.out.println(totalCost);
	        
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		// topKFrequent(nums, k);
		/*
		 * int[] cBits = countBits(15); for(int b:cBits){ System.out.println(b);
		 * }
		 */
		// 2147483648 (10000000000000000000000000000000)
		//System.out.println(hammingWeight(2147483648L));
		// kSmallestPairs(nums1, nums2, k);

	}

	public static String numberToWords(int num) {
		Map<Integer, String> mapNumToWords = new HashMap<Integer, String>();
		mapNumToWords.put(1, "one");
		mapNumToWords.put(2, "two");
		mapNumToWords.put(3, "three");
		mapNumToWords.put(4, "four");
		mapNumToWords.put(5, "five");
		mapNumToWords.put(6, "six");
		mapNumToWords.put(7, "seven");
		mapNumToWords.put(8, "eight");
		mapNumToWords.put(9, "nine");
		mapNumToWords.put(10, "ten");
		mapNumToWords.put(11, "eleven");
		mapNumToWords.put(12, "twelve");
		mapNumToWords.put(13, "thirteen");
		mapNumToWords.put(15, "fifteen");
		mapNumToWords.put(18, "eighteen");
		mapNumToWords.put(20, "twenty");
		return "";
	}

	public static int superPow(int a, int[] b) {
		int modNum = 1337;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			sb.append(b[i]);
		}
		BigDecimal exp = new BigDecimal(sb.toString());

		BigDecimal tempA = new BigDecimal(String.valueOf(Math.log10(a)));
		BigDecimal tempB = exp.multiply(tempA);
		BigDecimal tempC = new BigDecimal(String.valueOf(Math.log10(modNum)));
		while (tempB.compareTo(tempC) == 1) {
			tempB = tempB.subtract(tempC);
		}
		return (int) Math.pow(10, tempB.doubleValue());
	}

	public static boolean isPerfectSquare(int num) {
		if (num == 1)
			return true;
		else if (num < 1)
			return false;
		else {
			for (int i = 1; i <= num / 2; i++) {
				if (i * i == num || num == 1) {
					return true;
				}
			}

			return false;
		}

	}

	public static void kSmallestPairs(int[] nums1, int[] nums2, int k) {
		Queue<NumPair> qPairs = new PriorityQueue<NumPair>();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				NumPair np = new NumPair(nums1[i] + nums2[j], nums1[i],
						nums2[j]);
				qPairs.offer(np);
			}
		}
		Map<String, Integer> tMap = new HashMap<String, Integer>();
		NumPair np1 = qPairs.poll();
		NumPair np2 = qPairs.poll();
		NumPair np3 = qPairs.poll();
		System.out.println(np1.sum + " ----> formed by pair " + np1.num1 + ","
				+ np1.num2);
		System.out.println(np2.sum + " ----> formed by pair " + np2.num1 + ","
				+ np2.num2);
		System.out.println(np3.sum + " ----> formed by pair " + np3.num1 + ","
				+ np3.num2);
	}

	public static void topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> numFreq = new HashMap<Integer, Integer>();
		int tempFreq = 1;
		for (int i = 0; i < nums.length; i++) {
			if (numFreq.containsKey(nums[i])) {
				tempFreq = numFreq.get(nums[i]);
				tempFreq++;
			}

			numFreq.put(nums[i], tempFreq);
			tempFreq = 1;
		}

		List<Entry<Integer, Integer>> numFreqList = new ArrayList<Entry<Integer, Integer>>(
				numFreq.entrySet());
		Collections.sort(numFreqList,
				new Comparator<Map.Entry<Integer, Integer>>() {
					public int compare(Map.Entry<Integer, Integer> o1,
							Map.Entry<Integer, Integer> o2) {
						return (o2.getValue()).compareTo(o1.getValue());
					}
				});

		int endIndex = k > numFreqList.size() ? numFreqList.size() : k;
		if (endIndex > 0) {
			numFreqList = numFreqList.subList(0, endIndex);
		}

		List<Integer> topFreqNums = new ArrayList<Integer>();
		for (Entry<Integer, Integer> entry : numFreqList) {
			topFreqNums.add(entry.getKey());
			System.out.println(entry.getKey());
		}
	}

	public static int[] countBits(int num) {
		int maxPow = (int) (Math.log(num) / Math.log(2));
		Stack<Integer> powQ = new Stack<Integer>();
		while (maxPow >= 0) {
			powQ.push((int) Math.pow(2, maxPow));
			--maxPow;
		}
		int tempBitCount = 1;
		int[] bitCounts = new int[num + 1];
		int tempPow = 0;
		for (int i = 1; i < num + 1; i++) {
			if (!powQ.isEmpty() && i == powQ.peek()) {
				tempPow = powQ.pop();
			} else {
				tempBitCount += bitCounts[i - tempPow];
			}

			bitCounts[i] = tempBitCount;
			tempBitCount = 1;
		}

		return bitCounts;
	}

	public static int hammingWeight(long n) {
		int sumBit = 0;
		while (n > 0) {
			sumBit += n % 2;
			n = n / 2;
		}

		return sumBit;
	}

	public static int guessNumber(int n) {
		int pickedNum = (int) Math.random() * n;
		Scanner in = new Scanner(System.in);
		int guessN = in.nextInt();
		switch (guess(guessN)) {
		case -1:
			System.out.println("number is lower");
		}
		return 0;
	}

	private static int guess(int guessN) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int mySqrt(int y) {
		double x = Math.pow(10, Math.log10(y) / 2);
		return (int) x;
	}

	public static double myPow(double x, int n) {
		double result;
		if (x < 0) {
			result = Math.pow(10, n * Math.log10(-x));
			if (n % 2 != 0)
				result = 0 - result;
		} else {
			result = Math.pow(10, n * Math.log10(x));
		}

		return result;
	}
}

class NumPair implements Comparable<NumPair> {
	int sum;
	int num1;
	int num2;

	public NumPair(int sum, int num1, int num2) {
		this.sum = sum;
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public int compareTo(NumPair o) {
		// TODO Auto-generated method stub
		return this.sum - o.sum;
	}
}

class Num implements Comparable<Num> {

	String num;

	public Num() {

	}

	public Num(String nextLine) {
		// TODO Auto-generated constructor stub
		num = nextLine;
	}

	public String getNum() {
		return num;
	}

	@Override
	public int compareTo(Num o) {
		BigDecimal n = new BigDecimal(o.getNum());
		BigDecimal nThis = new BigDecimal(num);
		return nThis.compareTo(n);
	}

}