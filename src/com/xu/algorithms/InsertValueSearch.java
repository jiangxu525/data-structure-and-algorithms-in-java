package com.xu.algorithms;
/*
 * InsertValueSearch can only be used to array in order.
 */

import java.util.Arrays;

/**
 * 
 * @ClassName: InsertValueSearch
 * @Description: algorithm for InsertValueSearch
 * @author Xu
 * @date 2020-04-07 11:09:38
 */
public class InsertValueSearch {

	public static void main(String[] args) {
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		System.out.println(Arrays.toString(arr));
		int value = 5;
		int index = insertValueSearch(arr, 0, arr.length - 1, value);
		System.out.println("The index of " + value + " is " + index);
	}

	/**
	 * 
	 * @Title: insertValueSearch
	 * @Description: using recursion to achieve insertValueSearch
	 * @param arr
	 * @param left:    starting index
	 * @param right:   finishing index
	 * @param findVal: the value needs to be searched
	 * @return the index of findVal
	 * @author Xu
	 * @date 2020-03-07 11:09:58
	 */
	public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
		if (left > right || findVal < arr[0] || findVal > arr[right]) {
			return -1;
		}

		int mid = left + (findVal - arr[left]) / (arr[right] - arr[left]) * (right - left);
		int midVal = arr[mid];
		if (findVal > midVal) {
			return insertValueSearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) {
			return insertValueSearch(arr, left, mid - 1, findVal);
		} else {
			return mid;
		}

	}

}
