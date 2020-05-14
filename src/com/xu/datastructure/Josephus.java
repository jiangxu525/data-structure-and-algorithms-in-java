/*
 * People are standing in a circle waiting to be executed. 
 * Counting begins at a specified point in the circle and proceeds around the circle in a
 * specified direction. After a specified number of people are skipped, the next person is 
 * executed. The procedure is repeated with the remaining people, starting with the next person,
 * going in the same direction and skipping the same number of people, until only one person remains, 
 * and is freed[1].
 * 1. https://en.wikipedia.org/wiki/Josephus_problem
 * Author: Xu Jiang
 * Date: 2020-04-15
 */

package com.xu.datastructure;

public class Josephus {

	public static void main(String[] args) {
		CircleSingleLinkedList list = new CircleSingleLinkedList();
		list.addBoy(10);
		list.showBoy();
		list.countBoy(1, 2, 5);
	}

}

class CircleSingleLinkedList {
	// create the first node
	private Boy first;
/*
 * add boys to the circle
 * @param the number of boys in the circle linked list
 */
	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("Number must be higher than 1");
			return;
		}
		Boy curBoy = null;
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.setNext(first);
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}

		}
	}

	public void showBoy() {
		if (this.first == null) {
			System.out.println("No boy!");
			return;
		}
		Boy curBoy = first;
		while (true) {
			System.out.println(curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
	}

	// based on requirement
	/*
	 * @param startNo, start count
	 * 
	 * @param countNum
	 * 
	 * @param nums: the number of boys
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("Wrong input, please enter correct number again.");
			return;
		}

		Boy helper = first;
		while (true) {
			if (helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}

		for (int i = 0; i < (startNo - 1); i++) {
			first.getNext();
			helper.getNext();
		}

		while (true) {
			if (helper == first) {
				break;
			}
			for (int j = 0; j < (countNum - 1); j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.println(first.getNo() + " out!");
			helper.setNext(first.getNext());
			first = first.getNext();

		}

		System.out.println("the last boy is " + first.getNo());

	}
}

class Boy {
	private int no;
	private Boy next;

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

}