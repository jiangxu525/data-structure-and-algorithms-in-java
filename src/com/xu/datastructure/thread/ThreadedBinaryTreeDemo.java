package com.xu.datastructure.thread;
/**
 * 
 * @ClassName: ThreadedBinaryTreeDemo
 * @Description: demo for threaded binary tree
 * @author Xu
 * @date 2020-06-08 10:11:41
 */

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		PersonNode root = new PersonNode(1, "Tom");
		PersonNode node2 = new PersonNode(3, "Jack");
		PersonNode node3 = new PersonNode(6, "Smith");
		PersonNode node4 = new PersonNode(8, "Mary");
		PersonNode node5 = new PersonNode(10, "King");
		PersonNode node6 = new PersonNode(14, "Tim");
		
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		
		ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
		threadedBinaryTree.setRoot(root);
		threadedBinaryTree.threadedNodes();
		
		System.out.println(node5.getLeft()); //3
		System.out.println(node5.getRight());//1

		System.out.println("*********************");
		threadedBinaryTree.threadedList();
		
	}

}
/**
 * 
 * @ClassName: ThreadedBinaryTree
 * @Description: infix treaded binary tree
 * @author Xu
 * @date 2020-06-08 10:12:02
 */
class ThreadedBinaryTree {
	private PersonNode root;
	private PersonNode pre;
	
	public void threadedNodes() {
		threadedNodes(root);
	}
	
	public void threadedList() {
		PersonNode node = root;
		while(node!=null) {
			while(node.getLeftType()==0) {
				node=node.getLeft();
			}
			System.out.println(node);
			while(node.getRightType()==1) {
				node= node.getRight();
				System.out.println(node);
			}
			node= node.getRight();
		}
	}
	
	public void threadedNodes(PersonNode node) {
		if(node == null) {
			return;
		}
		threadedNodes(node.getLeft());
		
		if(node.getLeft()==null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if(pre!=null && pre.getRight()==null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		pre=node;
		threadedNodes(node.getRight());
	}

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
		if(root!=null) {
			if(root.getId()==id) {
				root=null;
			}else {
				root.delNode(id);
			}
		}else {
			System.out.println("Empty tree!!");
		}
		
	}

}
/**
 * 
 * @ClassName: PersonNode
 * @Description: bean node
 * @author Xu
 * @date 2020-06-08 10:12:19
 */
class PersonNode {
	private int id;
	private String name;
	private PersonNode left;
	private PersonNode right;
	
	// 0--> left/right tree  1-->predecessor/successor
	private int leftType, rightType;

	public PersonNode(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	

	public int getLeftType() {
		return leftType;
	}



	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}



	public int getRightType() {
		return rightType;
	}



	public void setRightType(int rightType) {
		this.rightType = rightType;
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
	
	//delete
	public void delNode(int id) {
		if(this.getLeft()!=null&&this.getLeft().id ==id) {
			this.setLeft(null);
			return;
		}
		
		if(this.getRight()!=null&&this.getRight().id ==id) {
			this.setRight(null);
			return;
		}
		
		if(this.getLeft()!=null) {
			this.getLeft().delNode(id);
		}
		
		if(this.getRight()!=null) {
			this.getRight().delNode(id);
		}
		
		
		
	}

}
