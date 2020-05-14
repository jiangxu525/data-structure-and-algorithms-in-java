package com.xu.datastructure;

public class ArrBinaryTreeDemo {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
		arrayBinaryTree.preOrder();
		System.out.println("************");
		arrayBinaryTree.infixOrder();
		System.out.println("************");
		arrayBinaryTree.postOrder();
	}
}

class ArrayBinaryTree {
	private int[] arr;

	public ArrayBinaryTree(int[] arr) {
		this.arr = arr;
	}

	public void preOrder() {
		preOrder(0);
	}

	public void preOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("Empty array");
		}
		System.out.println(arr[index]);
		if ((index * 2 + 1) < arr.length) {
			preOrder(2 * index + 1);
		}

		if ((index * 2 + 2) < arr.length) {
			preOrder(2 * index + 2);
		}
	}

	public void infixOrder() {
		infixOrder(0);
	}

	public void infixOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("Empty array");
		}

		if ((index * 2 + 1) < arr.length) {
			infixOrder(2 * index + 1);
		}

		System.out.println(arr[index]);

		if ((index * 2 + 2) < arr.length) {
			infixOrder(2 * index + 2);
		}
	}

	public void postOrder() {
		postOrder(0);
	}

	public void postOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("Empty array");
		}
		if ((index * 2 + 1) < arr.length) {
			postOrder(2 * index + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			postOrder(2 * index + 2);
		}
		System.out.println(arr[index]);
	}
}