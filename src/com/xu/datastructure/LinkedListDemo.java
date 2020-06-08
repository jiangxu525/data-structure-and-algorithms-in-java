package com.xu.datastructure;

import java.util.Stack;

/**
 * 
 * @ClassName: LinkedListDemo
 * @Description: test the various methods of SingleLinkedList
 * @author Xu
 * @date 2020-06-08 09:57:03
 */
public class LinkedListDemo {
	// this main method is used to test the various methods of SingleLinkedList
	public static void main(String[] args) {
		Node node1 = new Node(1, "A");
		Node node2 = new Node(2, "B");
		Node node3 = new Node(3, "C");
		Node node4 = new Node(4, "D");

		SingleLinkedList list = new SingleLinkedList();
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.show();
		System.out.println("**************************");
		list.reverse();
		list.show();

	}
}

/**
 * 
 * @ClassName: SingleLinkedList
 * @Description: Single Linked List
 * @author Xu
 * @date 2020-06-08 09:57:14
 */
class SingleLinkedList {
	/**
	 * head is the default head for the single linked list
	 */
	private Node head = new Node(0, "");

	/**
	 * 
	 * @Title: reverse
	 * @Description: reverse the list
	 * @author Xu
	 * @date 2020-06-08 09:57:35
	 */
	public void reverse() {
		Node temp = head.getNext();
		head.setNext(null);
		if (temp != null && temp.getNext() != null) {
			while (temp != null) {
				Node value = temp;
				temp = temp.getNext();
				value.setNext(head.getNext());
				head.setNext(value);
				;
			}
		}

	}

	/**
	 * 
	 * @Title: find
	 * @Description: find the node based on the index of k
	 * @param k
	 * @return the node found
	 * @author Xu
	 * @date 2020-06-08 09:57:43
	 */
	public Node find(int k) {
		Node temp = head.getNext();
		int index = 0;
		while (temp != null) {
			index++;
			temp = temp.getNext();
		}
		if (index < k) {
			System.out.println("Not found.");
			return null;
		}
		temp = head.getNext();
		for (int i = 0; i < (index - k); i++) {
			temp = temp.getNext();
		}
		return temp;
	}

	/**
	 * 
	 * @Title: add
	 * @Description: add a node to the end of the SingleLinkedList
	 * @param node
	 * @author Xu
	 * @date 2020-06-08 09:58:07
	 */
	public void add(Node node) {
		Node tmp = head;
		while (true) {
			if (tmp.getNext() == null) {
				break;
			}

			tmp = tmp.getNext();
		}

		tmp.setNext(node);
	}

	/**
	 * 
	 * @Title: addByOrder
	 * @Description: add a new node based on the no. of the node
	 * @param node
	 * @author Xu
	 * @date 2020-06-08 09:58:16
	 */
	public void addByOrder(Node node) {
		Node temp = head;
		while (true) {
			if (temp.getNext() == null) {
				node.setNext(null);
				;
				temp.setNext(node);
				;
				break;
			}
			if (temp.getNext().getNo() > node.getNo()) {
				node.setNext(temp.getNext());
				temp.setNext(node);
				break;
			} else if (temp.getNext().getNo() == node.getNo()) {
				System.out.println("Already exist!!!");
				break;
			}
			temp = temp.getNext();
		}
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: delete node based on the node number
	 * @param no: the number of the node that needs to be deleted
	 * @author Xu
	 * @date 2020-06-08 09:58:27
	 */
	public void delete(int no) {
		Node temp = head;
		while (true) {
			if (temp.getNext() == null) {
				System.out.println("no record found!");
				break;
			}
			if (temp.getNext().getNo() == no) {
				temp.setNext(temp.getNext().getNext());
				break;
			}
			temp = temp.getNext();
		}

	}

	/**
	 * 
	 * @Title: update
	 * @Description: update the information of a node
	 * @param node
	 * @author Xu
	 * @date 2020-06-08 09:58:43
	 */

	public void update(Node node) {
		if (head.getNext() == null) {
			System.out.println("Blank!!");
		}
		Node temp = head.getNext();

		while (true) {
			if (temp == null) {
				System.out.println("No found!");
				break;
			}

			if (temp.getNo() == node.getNo()) {
				temp.setValue(node.getValue());
				break;
			}
			temp = temp.getNext();
		}

	}

	/**
	 * 
	 * @Title: reverseShow
	 * @Description: show the nodes contained in reverse order
	 * @author Xu
	 * @date 2020-06-08 09:58:54
	 */
	public void reverseShow() {
		Stack<Node> stack = new Stack<>();
		if (head.getNext() == null) {
			System.out.println("Empty!");
			return;
		}

		Node tmp = head.getNext();
		while (true) {
			if (tmp == null) {
				break;
			}
			stack.add(tmp);
			tmp = tmp.getNext();
		}

		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
/**
 * 
 * @Title: show
 * @Description: TODO
 * @author Xu
 * @date 2020-06-08 09:59:11
 */
	// print the nodes contained
	public void show() {

		if (head.getNext() == null) {
			System.out.println("Empty!");
			return;
		}

		Node tmp = head.getNext();
		while (true) {
			if (tmp == null) {
				break;
			}
			System.out.println(tmp);
			tmp = tmp.getNext();
		}

	}
}
/**
 * 
 * @ClassName: Node
 * @Description: Node class
 * @author Xu
 * @date 2020-06-08 10:06:37
 */
class Node {
	private int no;
	private String value;
	/**
	 * 	next is used to store the next Node that this node is linked to.
	 */
	private Node next;

	public Node(int no, String value) {
		this.no = no;
		this.value = value;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", value=" + value + "]";
	}

}
