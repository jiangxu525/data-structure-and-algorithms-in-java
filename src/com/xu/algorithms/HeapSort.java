package com.xu.algorithms;

import java.util.Arrays;

/**
 * 
 * @ClassName: HeapSort
 * @Description: Heap sort solution
 * @author Xu
 * @date 2020-03-07
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] arr = new int[20];
		for (int i = 0; i < 20; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("After heap sort:");
		heapSort(arr);
	}

	/**
	 * 
	 * @Title: heapSort
	 * @Description: sort the arr using heap sort method
	 * @param arr
	 * @author Xu
	 * @date 2020-03-07
	 */
	public static void heapSort(int[] arr) {
		int temp;
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}

		for (int j = arr.length - 1; j > 0; j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, j);
		}
		System.out.println(Arrays.toString(arr));

	}

	/**
	 * 
	 * @Title: adjustHeap
	 * @Description: convert an array to top-down heap
	 * @param arr
	 * @param i
	 * @param length
	 * @author Xu
	 * @date 2020-03-07
	 */
	public static void adjustHeap(int[] arr, int i, int length) {
		int temp = arr[i];
		for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
			if (k + 1 < length && arr[k] < arr[k + 1]) {// node left less than node right
				k++;
			}
			if (arr[k] > temp) {
				arr[i] = arr[k];
				i = k;
			} else {
				break;
			}
		}
		arr[i] = temp;
	}
}
