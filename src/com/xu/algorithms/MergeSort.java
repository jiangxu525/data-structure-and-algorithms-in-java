package com.xu.algorithms;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[80];
		for (int i = 0; i < 80; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		int[] temp = new int[arr.length];
		System.out.println(Arrays.toString(arr));
		mergeSort(arr,0,arr.length-1,temp);
		System.out.println("After quick sort:");
		System.out.println(Arrays.toString(arr));
	}

	// divide
	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid + 1, right, temp);
			merge(arr, left, mid, right, temp);
		}
	}

	// merge
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int l = left;
		int r = mid + 1;
		int t = 0;

		while (l <= mid && r <= right) {
			temp[t] = Math.min(arr[l], arr[r]);
			t++;
			if (arr[l] > arr[r]) {
				r++;
			} else {
				l++;
			}
		}
		while (l <= mid) {
			temp[t] = arr[l];
			t++;
			l++;
		}
		while (r <= right) {
			temp[t] = arr[r];
			t++;
			r++;
		}
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			tempLeft++;
			t++;
		}
	}
}