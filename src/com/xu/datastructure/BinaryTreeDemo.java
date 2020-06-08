package com.xu.datastructure;

/**
 * 
 * @ClassName: BinaryTreeDemo
 * @Description: demo for binary tree
 * @author Xu
 * @date 2020-06-07 11:23:07
 */
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

		binaryTree.delNode(5);
		binaryTree.preOrder();
		System.out.println("***************");

	}

}

/**
 * 
 * @ClassName: BinaryTree
 * @Description: Binary Tree
 * @author Xu
 * @date 2020-06-07 11:23:27
 */
class BinaryTree {
	/**
	 * root node
	 */
	private PersonNode root;

	/**
	 * 
	 * @Title: getRoot
	 * @Description: getter for root
	 * @return root node
	 * @author Xu
	 * @date 2020-06-07 11:24:19
	 */
	public PersonNode getRoot() {
		return root;
	}

	/**
	 * 
	 * @Title: setRoot
	 * @Description: setter for root node
	 * @param root
	 * @author Xu
	 * @date 2020-06-07 11:24:41
	 */
	public void setRoot(PersonNode root) {
		this.root = root;
	}

	/**
	 * 
	 * @Title: preOrder
	 * @Description: preOrder
	 * @author Xu
	 * @date 2020-06-07 11:24:52
	 */
	public void preOrder() {
		if (this.getRoot() != null) {
			this.getRoot().preOrder();
		}
	}

	/**
	 * 
	 * @Title: infixOrder
	 * @Description: infixOrder
	 * @author Xu
	 * @date 2020-06-07 11:25:42
	 */
	public void infixOrder() {
		if (this.getRoot() != null) {
			this.getRoot().infixOrder();
		}
	}

	/**
	 * 
	 * @Title: postOrder
	 * @Description: postOrder
	 * @author Xu
	 * @date 2020-06-07 11:25:47
	 */
	public void postOrder() {
		if (this.getRoot() != null) {
			this.getRoot().postOrder();
		}
	}

	/**
	 * 
	 * @Title: preOrderSearch
	 * @Description: preOrderSearch
	 * @param id: the index that needs to be found
	 * @return the node of id. return null if not found
	 * @author Xu
	 * @date 2020-06-07 11:25:53
	 */
	public PersonNode preOrderSearch(int id) {
		if (root != null) {
			return root.preOrderSearch(id);
		}
		return null;
	}
/**
 * 
 * @Title: infixOrderSearch
 * @Description: infixOrderSearch
 * @param id: the index that needs to be found
 * @return the node of id. return null if not found
 * @author Xu
 * @date 2020-06-07 11:26:45
 */
	public PersonNode infixOrderSearch(int id) {
		if (root != null) {
			return root.infixOrderSearch(id);
		}
		return null;
	}
/**
 * 
 * @Title: postOrderSearch
 * @Description: postOrderSearch
 * @param id: the index that needs to be found
 * @return the node of id. return null if not found
 * @author Xu
 * @date 2020-06-07 11:27:05
 */
	public PersonNode postOrderSearch(int id) {
		if (root != null) {
			return root.postOrderSearch(id);
		}
		return null;
	}
/**
 * 
 * @Title: delNode
 * @Description: delete a node
 * @param id: the index of the node that needs to be deleted
 * @author Xu
 * @date 2020-06-07 11:27:22
 */
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
/**
 * 
 * @ClassName: PersonNode
 * @Description: PersonNode class
 * @author Xu
 * @date 2020-06-07 11:27:45
 */
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
/**
 * 
 * @Title: preOrderSearch
 * @Description: preOrderSearch
 * @param id: the index that needs to be searched
 * @return the node found
 * @author Xu
 * @date 2020-06-07 11:29:18
 */
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
/**
 * 
 * @Title: infixOrderSearch
 * @Description: infixOrderSearch
 * @param id: the index that needs to be searched
 * @return the node found
 * @author Xu
 * @date 2020-06-07 11:29:01
 */
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
/**
 * 
 * @Title: postOrderSearch
 * @Description: postOrderSearch
 * @param id: the index that needs to be searched
 * @return the node found
 * @author Xu
 * @date 2020-06-07 11:28:39
 */
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
/**
 * 
 * @Title: delNode
 * @Description: delete certain node
 * @param id: the index that needs to be deleted
 * @author Xu
 * @date 2020-06-07 11:28:16
 */
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
