package com.xu.algorithms;

import java.util.Arrays;

public class SeqSearch {

	public static void main(String[] args) {

		int[] arr = new int[80];
		for (int i = 0; i < 80; i++) {
			arr[i] = (int) (Math.random() * 50);
		}
		System.out.println(Arrays.toString(arr));
		int value = 1;
		int index = seqSearch(arr, value);
		System.out.println("The index of " +value +" is " + index);
	}

	/*
	 * @param arr, the array needs to be searched
	 * @param value, the value in the array
	 * @return the index of the value. if not found return -1
	 */
	public static int seqSearch(int[] arr, int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

}
