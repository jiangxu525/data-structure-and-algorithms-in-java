package com.xu.algorithms;

import java.util.Arrays;

/**
 * 
 * @ClassName: QuickSort
 * @Description: algorithm for QuickSort
 * @author Xu
 * @date 2020-06-07 11:13:36
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[80];
		for (int i = 0; i < 80; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("After quick sort:");
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 
	 * @Title: quickSort
	 * @Description: algorithm for QuickSort
	 * @param arr
	 * @param left
	 * @param right
	 * @author Xu
	 * @date 2020-06-07 11:13:49
	 */
	public static void quickSort(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		int l = left;
		int r = right;
		int temp = 0;
		while (l < r) {
			while (arr[l] < pivot) {
				l++;
			}
			while (arr[r] > pivot) {
				r--;
			}
			if (l == r) {
				break;
			}
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			if (arr[l] == pivot) {
				r--;
			}

			if (arr[r] == pivot) {
				l++;
			}
		}
		l++;
		r--;
		if (left < r) {
			quickSort(arr, left, r);
		}

		if (right > l) {
			quickSort(arr, l, right);
		}

	}

}