package com.xu.algorithms;
/*
 * In computer science, the Fibonacci search technique is a method of searching a 
 * sorted array using a divide and conquer algorithm that narrows down possible 
 * locations with the aid of Fibonacci numbers[1].
 * 
 * 1. https://en.wikipedia.org/wiki/Fibonacci_search_technique
 */


//FibonacciSearch can only be used to array in order.

import java.util.Arrays;

public class FibonacciSearch {
	public static int maxSize = 20;

	public static void main(String[] args) {
		int[] arr = { 1, 8, 10,11,12,1000, 1234,1500 };
		System.out.println(Arrays.toString(arr));
		int value = 1234;
		int index = fibSearch(arr,  value);
		System.out.println("The index of " +value +" is " + index);	
	}

	// create a Fibonaccy
	public static int[] fib() {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}

	public static int fibSearch(int[] arr, int findVal) {
		int low = 0;
		int high = arr.length - 1;
		int k = 0;
		int mid = 0;
		int[] f = fib();
		while (high > f[k] - 1) {
			k++;
		}
		int[] temp = Arrays.copyOf(arr, f[k]);
		for (int i = high + 1; i < temp.length; i++) {
			temp[i] = arr[high];
		}

		while (low <= high) {
			if(low==high) {
				mid = low;
			}else {
				mid = low + f[k - 1] - 1;
			}
			if (findVal < temp[mid]) {
				high = mid ;
				k--;
			} else if (findVal > temp[mid]) {
				low = mid + 1;
				k -= 2;
			} else {
				if (mid <= high) {
					return mid;
				} else {
					return high;
				}
			}
		}
		return -1;
	}

}
