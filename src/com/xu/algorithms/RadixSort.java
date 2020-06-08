package com.xu.algorithms;

import java.util.Arrays;

/**
 * 
 * @ClassName: RadixSort
 * @Description: algorithm for RadixSort
 * @author Xu
 * @date 2020-06-07 11:14:03
 */
public class RadixSort {

	public static void main(String[] args) {
		int[] arr = new int[80];
		for (int i = 0; i < 80; i++) {
			arr[i] = (int) (Math.random() * 1000);
		}
		System.out.println(Arrays.toString(arr));
		radixSort(arr);
		System.out.println("After radix sort:");
		System.out.println(Arrays.toString(arr));

	}

	/**
	 * 
	 * @Title: radixSort
	 * @Description: algorithm for RadixSort
	 * @param arr
	 * @author Xu
	 * @date 2020-06-07 11:14:14
	 */
	public static void radixSort(int[] arr) {
		int[][] bucket = new int[10][arr.length];
		int[] bucketIndex = new int[10];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int maxLength = (max + "").length();

		for (int i = 0; i < maxLength; i++) {

			for (int j = 0; j < arr.length; j++) {
				int digitOfElement = arr[j] / ((int) Math.pow(10, i)) % 10;
				bucket[digitOfElement][bucketIndex[digitOfElement]] = arr[j];
				bucketIndex[digitOfElement]++;
			}
			int index = 0;
			for (int k = 0; k < bucketIndex.length; k++) {
				if (bucketIndex[k] != 0) {
					for (int m = 0; m < bucketIndex[k]; m++) {
						arr[index++] = bucket[k][m];
					}
				}
				bucketIndex[k] = 0;
			}
		}
	}

}
