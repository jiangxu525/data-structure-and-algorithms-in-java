package com.xu.datastructure.binarysorttree;

public class BinarySortTreeDemo {

	public static void main(String[] args) {
		int[] arr = { 7, 3, 10, 12, 5, 1, 9, 2 };
		BinarySortTree binarySortTree = new BinarySortTree();
		for (int i : arr) {
			binarySortTree.add(new Node(i));
		}
		binarySortTree.infixOrder();
		System.out.println("************");
		binarySortTree.delNode(10);
		binarySortTree.infixOrder();
	}

}

class BinarySortTree {
	private Node root;

	public Node search(int value) {
		if (root == null) {
			return null;
		}
		return root.search(value);
	}

	public Node searchParent(int value) {
		if (root == null) {
			return null;
		}
		return root.searchParent(value);
	}

	public void delNode(int value) {
		if (root == null) {
			return;
		} else {
			Node targetNode = search(value);
			if (targetNode == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			Node parentNode = searchParent(value);
			if (targetNode.left == null && targetNode.right == null) {// contains no sub
				if (parentNode.left != null && parentNode.left.value == value) {
					parentNode.left = null;
				} else if (parentNode.right != null && parentNode.right.value == value) {
					parentNode.right = null;
				}
			} else if (targetNode.left != null && targetNode.right != null) {// contains two subs
				int minVal = DdelRghtTreeMin(targetNode.right);
				targetNode.value = minVal;
			} else { // contains one sub
				if (targetNode.left != null) {
					if (parentNode.left.value == value) {
						parentNode.left = targetNode.left;
					} else {
						parentNode.right = targetNode.left;
					}
				} else {
					if (parentNode.right.value == value) {
						parentNode.right = targetNode.right;
					} else {
						parentNode.left = targetNode.right;
					}
				}
			}
		}
	}

	public int DdelRghtTreeMin(Node node) {
		Node target = node;
		while (target.left != null) {
			target = target.left;
		}
		// target contains the minimum value
		delNode(target.value);
		return target.value;
	}

	public void add(Node node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	public void infixOrder() {
		if (this.root == null) {
			System.out.println("Empty!!");
		} else {
			this.root.infixOrder();
		}
	}
}

class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}

	// add
	public void add(Node node) {
		if (node == null) {
			return;
		}

		if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}
	}

	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	public Node search(int value) {
		if (this.value == value) {
			return this;
		} else if (value < this.value) {
			if (this.left == null) {
				return null;
			}
			return this.left.search(value);
		} else {
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}

	public Node searchParent(int value) {
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		} else {
			if (value < this.value && this.left != null) {
				return this.left.searchParent(value);
			} else if (value >= this.value && this.right != null) {
				return this.right.searchParent(value);
			} else {
				return null;

			}
		}
	}

}
