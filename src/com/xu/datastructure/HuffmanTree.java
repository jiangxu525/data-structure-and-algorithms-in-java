package com.xu.datastructure;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		int arr[]= {13,7,8,3,29,6,1};
		Node4 root = createHuffmanTree(arr);
		root.preOrder();
	}
	
	//create Huffman tree
	public static Node4 createHuffmanTree(int[] arr) {
		List<Node4> nodes = new ArrayList<>();
		for(int value:arr) {
			nodes.add(new Node4(value));
		}
		Node4 leftNode, rightNode, parentNode;
		while(nodes.size()>1) {
			Collections.sort(nodes);
			leftNode = nodes.get(0);
			rightNode= nodes.get(1);
			parentNode = new Node4(leftNode.value+rightNode.value);
			parentNode.left=leftNode;
			parentNode.right = rightNode;
			
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parentNode);
		}
		
		return nodes.get(0);
	}

}

class Node4 implements Comparable<Node4> {
	int value;
	Node4 left;
	Node4 right;
	
	public Node4(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node4 o) {
		return this.value- o.value;
	}
	
	public void preOrder() {
		System.out.println(this);
		if(this.left!=null) {
			this.left.preOrder();
		}
		
		if(this.right!=null) {
			this.right.preOrder();
		}
	}
	
	
	
}