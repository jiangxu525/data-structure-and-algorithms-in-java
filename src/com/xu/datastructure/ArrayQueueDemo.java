package com.xu.datastructure;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			System.out.println("Please enter your option");
			System.out.println("s:show the array.");
			System.out.println("e:exit the program.");
			System.out.println("a:add a new value.");
			System.out.println("g:get the value.");
			System.out.println("h:print the head value.");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				arrayQueue.show();
				break;
			case 'a':
				System.out.println("Enter a number: ");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					System.out.println(arrayQueue.getQueue());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 'h':
				try {
					int res = arrayQueue.headQueue();
					System.out.println(res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("End!Thanks!");
	}

}

class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
	}

	public boolean isFull() {
		return (rear + 1) % this.maxSize == front;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("Full!!!");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Empty!!!");
		}
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;

	}

	public void show() {
		if (isEmpty()) {
			System.out.println("Empty!!!");
		} else {
			for (int i = 0; i < (rear + maxSize - front) % maxSize; i++) {
				System.out.println(arr[(front + i) % maxSize] + "\t");
			}
		}

	}

	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Empty!!!");
		}
		return arr[front];
	}

}