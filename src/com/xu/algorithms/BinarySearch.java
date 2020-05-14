package com.xu.algorithms;

import java.util.Arrays;

public class BinarySearch {
	
	//array must be ordered
	public static void main(String[] args) {
		int[] arr = new int[80];
		for (int i = 0; i < 80; i++) {
			arr[i] = (int) (Math.random() * 50);
		}
		System.out.println(Arrays.toString(arr));
		int value = 1;
		int resIndex = binarySearch(arr, 0, arr.length, value);
		System.out.println("The index of " +value +" is " + resIndex);
	}
	/*
	 * @param arr, the array needs to be searched
	 * @param left, the begin of the array to search
	 * @param right, the end of the array to search
	 * @param findVal, the value in the array
	 * @return the index of the value. if not found return -1
	 */
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		
		if(left>right) {
			return -1;
		}
		int mid = (left+right)/2;
		int midValue = arr[mid];
		if(findVal>midValue) {
			return binarySearch(arr, mid+1, right,findVal);
		}else if(findVal<midValue) {
			return binarySearch(arr,left,mid-1,findVal);
		}else {
			return mid;
		}
	}

}