package com.xu.datastructure;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// this main method is used to test the method of the DoubleLinkedList
		Node2 node1 = new Node2(1, "Tom");
		Node2 node2 = new Node2(2, "Peter");
		Node2 node3 = new Node2(3, "Daniel");
		Node2 node4 = new Node2(4, "Jane");
		DoubleLinkedList list = new DoubleLinkedList();
		//add new nodes
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.show();
		System.out.println("*************************");
		// update existing nodes
		Node2 node5 = new Node2(4, "Annie");
		list.update(node5);
		list.show();
//		list.delete(4);
//		list.show();
	}
}

class DoubleLinkedList {
	public Node2 head = new Node2(0, "");

	// return the head
	public Node2 getHead() {
		return head;
	}

	// print the DoubleLinkedList
	public void show() {
		if (head.getNext() == null) {
			System.out.println("Empty!");
			return;
		}
		Node2 temp = head.getNext();
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.getNext();
		}

	}

	// add a new node
	public void add(Node2 node) {
		Node2 tmp = head;
		while (true) {
			if (tmp.getNext() == null) {
				break;
			}
			tmp = tmp.getNext();
		}

		tmp.setNext(node);
		node.setPre(tmp);
	}

	// update an existing node
	public void update(Node2 node) {
		if (head.getNext() == null) {
			System.out.println("Blank!!");
		}
		Node2 temp = head.getNext();
		while (true) {
			if (temp == null) {
				System.out.println("No found!");
				break;
			}
			if (temp.getNo() == node.getNo()) {
				temp.setName(node.getName());
				break;
			}
			temp = temp.getNext();
		}
	}

	// delete a node based on the no.
	public void delete(int no) {
		Node2 temp = head;
		while (true) {
			if (temp == null) {
				System.out.println("no record found!");
				break;
			}
			if (temp.getNo() == no) {
				if (temp.getNext() == null) {
					temp.getPre().setNext(null);
					break;
				} else {
					temp.getPre().setNext(temp.getNext());
					temp.getNext().setPre(temp.getPre());
					break;
				}

			}
			temp = temp.getNext();
		}

	}

}
//Node2 class, and the difference from single linked list is that it contains a next and a pre
//Also, users can define the parameters like name as needed. 
class Node2 {
	private int no;
	private String name;
	private Node2 next;
	private Node2 pre;

	public Node2(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node2 getNext() {
		return next;
	}

	public void setNext(Node2 next) {
		this.next = next;
	}

	public Node2 getPre() {
		return pre;
	}

	public void setPre(Node2 pre) {
		this.pre = pre;
	}

	@Override
	public String toString() {
		return "Node2 [no=" + no + ", name=" + name + "]";
	}
}
