package com.xu.algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SparseArray {

	public static void main(String[] args) {
		//this main method is used to test the correctness of the SparseArray
		//create an original array, which represents a five-in-a-row game board,
		//0--blank  1--black  2-white
		int chessArray[][] = new int[11][11];
		chessArray[1][2] = 1;
		chessArray[2][3] = 2;
		//print out the 2d array
		for(int[] rows : chessArray) {
			for(int i : rows) {
				System.out.printf("%d\t" ,i);
			}
			System.out.println();
		}
		//count the number of cells that do not equal to 0.
		int nonZero = 0;
		for(int i = 0; i < chessArray.length; i++) {
			for(int j =0; j < 11; j++) {
				if(chessArray[i][j] !=0) {
					nonZero++;
				}
			}
		}
		/*
		 * create the sparse array
		 * 1st row: the total row number,    total column number,       total nonzero cells in the chessArray
		 * n row:   row number of the value, column number of the value,the value
		 * e.g. value 1 is in arr[1][2] so that: 1  2  1
		 */
		int sparseArr[][]=new int[nonZero+1][3];
		sparseArr[0][0]=chessArray.length;
		sparseArr[0][1]=chessArray[0].length;
		sparseArr[0][2]=nonZero;
		int sparseRow = 1;
		for(int i = 0; i < chessArray.length; i++) {
			for(int j =0; j < 11; j++) {
				if(chessArray[i][j] !=0) {
					sparseArr[sparseRow][0]=i;
					sparseArr[sparseRow][1]=j;
					sparseArr[sparseRow][2]=chessArray[i][j];
					sparseRow++;
				}
			}
		}
		
		//store the sparseArray into local drive
		ObjectOutputStream output = null;
		try {
			output=new ObjectOutputStream(new FileOutputStream("sparse.bat"));
			output.writeObject(sparseArr);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(output !=null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//restore the sparse array from sparse.bat file
		ObjectInputStream input = null;
		Object obj = null;
		
		try{
			input = new ObjectInputStream(new FileInputStream("sparse.bat"));
			obj = input.readObject();
		}catch (Exception e) {
		}finally {
			
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		int sparseArr2[][] = (int[][])obj;
		//print out the sparse array
		for(int[] rows : sparseArr2) {
			for(int i : rows) {
				System.out.printf("%d\t" ,i);
			}
			System.out.println();
		}
		//convert the sparse array to original 2d array
		int result[][]=new int[sparseArr2[0][0]][sparseArr2[0][1]];
		for(int i=1; i<= sparseArr2[0][2];i++) {
				result[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
		}
		
		for(int[] rows : result) {
			for(int i : rows) {
				System.out.printf("%d\t" ,i);
			}
			System.out.println();
		}
		
		
		
	}

}