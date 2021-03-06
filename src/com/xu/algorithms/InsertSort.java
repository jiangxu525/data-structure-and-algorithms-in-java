package com.xu.algorithms;

import java.util.Arrays;

/**
 * 
 * @ClassName: InsertSort
 * @Description: Insert Sort
 * @author Xu
 * @date 2020-06-07 11:07:52
 */
public class InsertSort {
	/**
	 * @Title: main
	 * @Description: test the insert sort function
	 * @param args
	 * @author Xu
	 * @date 2020-06-07 11:07:40
	 */
	public static void main(String[] args) {
		int[] arr = new int[20];
		for (int i = 0; i < 20; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(arr));
		insertSort(arr);
		// print out the result
		System.out.println("After insert sort:");
		System.out.println(Arrays.toString(arr));

	}

	/**
	 * 
	 * @Title: insertSort
	 * @Description: algorithm for insert sort
	 * @param arr
	 * @author Xu
	 * @date 2020-03-07
	 */
	public static void insertSort(int[] arr) {
		int insertValue;
		int insertIndex;
		for (int i = 1; i < arr.length; i++) {
			// from arr[i], to insert arr[i] into the arr[0]~arr[i-1];
			insertValue = arr[i];
			insertIndex = i - 1;
			while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			if (insertIndex + 1 != i) {
				arr[insertIndex + 1] = insertValue;
			}
		}
	}
}
