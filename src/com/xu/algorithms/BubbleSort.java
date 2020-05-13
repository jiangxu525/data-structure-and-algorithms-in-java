package com.xu.algorithms;

import java.util.Arrays;

public class BubbleSort {
	
	//test the bubble sort solution
	public static void main(String[] args) {
		
		int[] arr= new int[20];
		//create 20 random integers and put them in the array
		for(int i = 0; i <20;i++) {
			arr[i] = (int)(Math.random()*100);
		}
		bubbleSort(arr);
		//print out the result
		System.out.println(Arrays.toString(arr));
	}
	
	public static void bubbleSort(int[] arr) {
		int temp = 0;
		boolean flag = false;
		for(int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if(!flag) {
				break; 
			}else {
				flag = false;
			}
		}

	}
}
