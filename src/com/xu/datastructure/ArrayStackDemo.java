package com.xu.datastructure;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		while (loop) {
			System.out.println("show: show stack");
			System.out.println("exit: exit program");
			System.out.println("push: add value to stack");
			System.out.println("pop:  get value from stack");
			System.out.print("please enter your choice:");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "exit":
				scanner.close();
				System.out.println("Goodbye!");
				loop = false;
				break;
			case "push":
				System.out.println("Please enter the value you want to push");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					System.out.println("value is " + stack.pop());
				} catch (Exception e) {
					e.getMessage();
				}
				break;
			default:
				break;
			}
		}
	}
}

class ArrayStack {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}

	public boolean isFull() {
		return top == (maxSize - 1);
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int value) {
		if (isFull()) {
			System.out.println("Full!");
			return;
		}
		top++;
		stack[top] = value;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Empty!No data!");
		}

		int value = stack[top];
		top--;
		return value;
	}

	public void list() {
		if (isEmpty()) {
			System.out.println("No data!Empty!");
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d] is %d\n", i, stack[i]);
		}
	}
}