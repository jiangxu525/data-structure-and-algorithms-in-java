
/**
 * @Description:  A demo for BinarySearch. Array must be ordered.
 * @author Xu
 */
package com.xu.algorithms;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		int arr[] = { 1, 8, 10, 89, 1000, 1234 };

		System.out.println(Arrays.toString(arr));
		int value = 89;
		int resIndex = binarySearch(arr, 0, arr.length, value);
		System.out.println("The index of " + value + " is " + resIndex);
	}

	/**
	 * 
	 * @Title: binarySearch
	 * @Description: TODO
	 * @param arr:     the array needs to be searched
	 * @param left:    the begin of the array to search
	 * @param right:   the end of the array to search
	 * @param findVal: the value in the array
	 * @return the index of the value. if not found return -1
	 * @author Xu
	 * @date 2020-06-07 11:21:26
	 */

	public static int binarySearch(int[] arr, int left, int right, int findVal) {

		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midValue = arr[mid];
		if (findVal > midValue) {
			return binarySearch(arr, mid + 1, right, findVal);
		} else if (findVal < midValue) {
			return binarySearch(arr, left, mid - 1, findVal);
		} else {
			return mid;
		}
	}

}