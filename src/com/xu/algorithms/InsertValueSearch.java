package com.xu.algorithms;
/*
 * InsertValueSearch can only be used to array in order.
 */

import java.util.Arrays;

public class InsertValueSearch {
	
	public static void main(String[] args) {
		int[] arr = new int[100];
		for(int i =0;i<100;i++) {
			arr[i]= i+1;
		}
		System.out.println(Arrays.toString(arr));
		int value = 5;
		int index = insertValueSearch(arr, 0, arr.length-1, value);
		System.out.println("The index of " +value +" is " + index);		
	}
	
	public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
		if(left > right || findVal < arr[0] || findVal > arr[right]) {
			return -1;
		}
		
		int mid = left + (findVal - arr[left])/(arr[right] - arr[left]) * (right - left);
		int midVal = arr[mid];
		if(findVal>midVal) {
			return insertValueSearch(arr, mid+1,right,findVal);
		}else if(findVal<midVal) {
			return insertValueSearch(arr, left, mid - 1,findVal);
		}else {
			return mid;
		}
		
	}

}
