package com.xu.algorithms;

import java.util.Arrays;

/**
 * 
 * @ClassName: SelectSort
 * @Description: algorithm for SelectSort
 * @author Xu
 * @date 2020-06-07 11:14:36
 */
public class SelectSort {

	public static void main(String[] args) {

		int[] arr = new int[80];
		for (int i = 0; i < 80; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(arr));
		selectSort(arr);
		System.out.println("After sort:");
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 
	 * @Title: selectSort
	 * @Description: algorithm for SelectSort
	 * @param arr
	 * @author Xu
	 * @date 2020-06-07 11:14:46
	 */
	public static void selectSort(int[] arr) {
		int min = 0;
		int minIndex = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			min = arr[i];
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}

	}
}
