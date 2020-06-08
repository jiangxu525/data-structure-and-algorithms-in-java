package com.xu.algorithms;

import java.util.Arrays;

/**
 * 
 * @ClassName: ShellSort
 * @Description: algorithm for shell sort
 * @author Xu
 * @date 2020-06-07 11:16:03
 */
public class ShellSort {

	public static void main(String[] args) {

		int[] arr = new int[80];
		for (int i = 0; i < 80; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(arr));
		shellSort(arr);
		System.out.println("After sorting:");
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 
	 * @Title: shellSort
	 * @Description: algorithm for shell sort
	 * @param arr
	 * @author Xu
	 * @date 2020-06-07 11:16:19
	 */
	public static void shellSort(int[] arr) {
		int insertValue;
		int insertIndex;
		int groupNum = arr.length / 2;
		while (groupNum != 0) {
			for (int i = groupNum; i < arr.length; i++) {
				insertValue = arr[i];
				insertIndex = i - groupNum;
				while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
					arr[insertIndex + groupNum] = arr[insertIndex];
					insertIndex -= groupNum;
				}
				if (insertIndex + groupNum != i) {
					arr[insertIndex + groupNum] = insertValue;
				}
			}
			groupNum = groupNum / 2;
		}
	}
}
