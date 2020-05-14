package com.xu.datastructure;


public class BinaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();

		PersonNode employee1 = new PersonNode(1, "Tom");
		PersonNode employee2 = new PersonNode(2, "Jane");
		PersonNode employee3 = new PersonNode(3, "Jake");
		PersonNode employee4 = new PersonNode(4, "Alice");
		PersonNode employee5 = new PersonNode(5, "Anna");

		binaryTree.setRoot(employee1);
		employee1.setLeft(employee2);
		employee1.setRight(employee3);
		employee3.setRight(employee4);
		employee3.setLeft(employee5);

		binaryTree.preOrder();
		System.out.println("***************");
		binaryTree.infixOrder();
		System.out.println("*************");
		binaryTree.postOrder();
		System.out.println("*************");

//		PersonNode find = binaryTree.preOrderSearch(5);
//		System.out.println(find.getId() + "   " + find.getName());
//
//		find = binaryTree.infixOrderSearch(5);
//		System.out.println(find.getId() + "   " + find.getName());
//		
//		
//		find = binaryTree.postOrderSearch(5);
//		System.out.println(find.getId() + "   " + find.getName());

		binaryTree.delNode(5);
		binaryTree.preOrder();
		System.out.println("***************");

	}

}

class BinaryTree {
	private PersonNode root;

	public PersonNode getRoot() {
		return root;
	}

	public void setRoot(PersonNode root) {
		this.root = root;
	}

	public void preOrder() {
		if (this.getRoot() != null) {
			this.getRoot().preOrder();
		}
	}

	public void infixOrder() {
		if (this.getRoot() != null) {
			this.getRoot().infixOrder();
		}
	}

	public void postOrder() {
		if (this.getRoot() != null) {
			this.getRoot().postOrder();
		}
	}

	public PersonNode preOrderSearch(int id) {
		if (root != null) {
			return root.preOrderSearch(id);
		}
		return null;
	}

	public PersonNode infixOrderSearch(int id) {
		if (root != null) {
			return root.infixOrderSearch(id);
		}
		return null;
	}

	public PersonNode postOrderSearch(int id) {
		if (root != null) {
			return root.postOrderSearch(id);
		}
		return null;
	}

	public void delNode(int id) {
		if (root != null) {
			if (root.getId() == id) {
				root = null;
			} else {
				root.delNode(id);
			}
		} else {
			System.out.println("Empty tree!!");
		}

	}

}

class PersonNode {
	private int id;
	private String name;
	private PersonNode left;
	private PersonNode right;

	public PersonNode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonNode getLeft() {
		return left;
	}

	public void setLeft(PersonNode left) {
		this.left = left;
	}

	public PersonNode getRight() {
		return right;
	}

	public void setRight(PersonNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "PersonNode [id=" + id + ", name=" + name + "]";
	}

	public void preOrder() {
		System.out.println(this);
		if (this.getLeft() != null) {
			this.getLeft().preOrder();
		}
		if (this.getRight() != null) {
			this.getRight().preOrder();
		}
	}

	public void infixOrder() {
		if (this.getLeft() != null) {
			this.getLeft().infixOrder();
		}
		System.out.println(this);
		if (this.getRight() != null) {
			this.getRight().infixOrder();
		}
	}

	public void postOrder() {
		if (this.getLeft() != null) {
			this.getLeft().postOrder();
		}
		if (this.getRight() != null) {
			this.getRight().postOrder();
		}
		System.out.println(this);
	}

	public PersonNode preOrderSearch(int id) {
		System.out.println("*");
		if (this.getId() == id) {
			return this;
		}
		PersonNode resNode = null;
		if (this.getLeft() != null) {
			resNode = this.getLeft().preOrderSearch(id);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.getRight() != null) {
			resNode = this.getRight().preOrderSearch(id);
		}
		return resNode;
	}

	public PersonNode infixOrderSearch(int id) {
		PersonNode resNode = null;
		if (this.getLeft() != null) {
			resNode = this.getLeft().infixOrderSearch(id);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("*");
		if (this.getId() == id) {
			return this;
		}
		if (this.getRight() != null) {
			resNode = this.getRight().infixOrderSearch(id);
		}
		return resNode;
	}

	public PersonNode postOrderSearch(int id) {
		PersonNode resNode = null;
		if (this.getLeft() != null) {
			resNode = this.getLeft().postOrderSearch(id);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.getRight() != null) {
			resNode = this.getRight().postOrderSearch(id);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("*");
		if (this.getId() == id) {
			return this;
		}
		return null;
	}

	// delete
	public void delNode(int id) {
		if (this.getLeft() != null && this.getLeft().id == id) {
			this.setLeft(null);
			return;
		}
		if (this.getRight() != null && this.getRight().id == id) {
			this.setRight(null);
			return;
		}
		if (this.getLeft() != null) {
			this.getLeft().delNode(id);
		}
		if (this.getRight() != null) {
			this.getRight().delNode(id);
		}
	}
}
