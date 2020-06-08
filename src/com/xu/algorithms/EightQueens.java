/**
 * The eight queens puzzle is the problem of placing eight chess queens on an 8×8 chessboard
 *  so that no two queens threaten each other. For more information, please visit:
 *  https://en.wikipedia.org/wiki/Eight_queens_puzzle
 *  
 *  This algorithm aims to find all solutions to this puzzle. 
 *  Author: Xu
 *  Date: 2020-04-12
 */
package com.xu.algorithms;

public class EightQueens {
	/**
	 * the number of queens
	 */
	int max = 8;

	/**
	 * the array to store the result, arr= {0,4,7,5,2,6,1,3} index->row
	 * value->column
	 */

	int[] array = new int[max];

	/**
	 * the total number of solutions
	 */
	static int count = 0;

	public static void main(String[] args) {
		EightQueens queens = new EightQueens();
		queens.put(0);
		System.out.println("********************\nTotal number of solutions is:" + count);
	}

	/**
	 * 
	 * @Title: put
	 * @Description: put queen n in the chess board
	 * @param n: the number of queen
	 * @author Xu
	 * @date 2020-03-13
	 */
	public void put(int n) {
		if (n == max) {// n in (0-7) , if no = 8, return.
			print();
			count++;
			return;
		}

		for (int i = 0; i < max; i++) {
			/*
			 * put queen-> row n, column i
			 */
			array[n] = i;
			if (judge(n)) {
				// if ok -> put queen(n+1) -> row n+1, colum i (recursion)
				put(n + 1);
			}
		}
	}

	/**
	 * 
	 * @Title: judge
	 * @Description: check whether the number n queen has conflicts with previous
	 *               queens
	 * @param n
	 * @return return true if the same, otherwise return false
	 * @author Xu
	 * @date 2020-03-07
	 */
	private boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			// array[i]==array[n]: same column
			// Math.abs(n-i)==Math.abs(array[n]-array[i]): same diagonal
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @Title: print
	 * @Description: print the result
	 * @author Xu
	 * @date 2020-03-07
	 */
	private void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
