package com.xu.datastructure;

/**
 * 
 * @ClassName: ArrBinaryTreeDemo
 * @Description: demo for binary tree
 * @author Xu
 * @date 2020-06-07 11:18:38
 */
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

/**
 * 
 * @ClassName: ArrayBinaryTree
 * @Description: binary tree
 * @author Xu
 * @date 2020-06-07 11:19:00
 */
class ArrayBinaryTree {
	private int[] arr;

	/**
	 * 
	 * @Title: ArrayBinaryTree
	 * @Description: ArrayBinaryTree
	 * @param arr
	 * @author Xu
	 * @date 2020-06-07 11:19:17
	 */
	public ArrayBinaryTree(int[] arr) {
		this.arr = arr;
	}

	public void preOrder() {
		preOrder(0);
	}

	/**
	 * 
	 * @Title: preOrder
	 * @Description: display in preOrder
	 * @param index
	 * @author Xu
	 * @date 2020-06-07 11:19:38
	 */
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

	/**
	 * 
	 * @Title: infixOrder
	 * @Description: display in infixOrder
	 * @param index
	 * @author Xu
	 * @date 2020-06-07 11:20:06
	 */
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

	/**
	 * 
	 * @Title: postOrder
	 * @Description: display in postOrder
	 * @param index
	 * @author Xu
	 * @date 2020-06-07 11:20:18
	 */
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