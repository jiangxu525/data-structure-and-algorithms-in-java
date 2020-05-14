package com.xu.datastructure;

public class LinkedListStackDemo {

	public static void main(String[] args) {
		LinkedListStack stack = new LinkedListStack();
		Node3 node1 = new Node3(10);
		Node3 node2 = new Node3(20);
		Node3 node3 = new Node3(30);
		Node3 node4 = new Node3(40);
		
		stack.add(node1);
		stack.add(node2);
		stack.add(node3);
		stack.add(node4);
		stack.show();
	}
}

class LinkedListStack{
	private Node3 top;
	public Node3 getTop() {
		return top;
	}

	public void setTop(Node3 top) {
		this.top = top;
	}

	public boolean isEmpty() {
		return this.getTop() == null;
	}
	
	public void add(Node3 value) {
		if(isEmpty()) {
			this.setTop(value); 
			return;
		}
		value.setNext(this.getTop());
		this.setTop(value);
	}
	
	public void show(){
		if(isEmpty()) {
			System.out.println("No data! Empty!!");
			return;
		}
		Node3 temp = this.getTop();
		while(temp!=null) {
			System.out.println(temp.getValue());
			temp=temp.getNext();
		}
		
	}
	
	
}



class Node3{
	private Node3 next;
	private int value;
	public Node3(int value) {
		this.value=value;
	}
	public Node3 getNext() {
		return next;
	}
	public void setNext(Node3 next) {
		this.next = next;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
