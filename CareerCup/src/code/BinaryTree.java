package code;

public class BinaryTree {
	int data;
	BinaryTree left;
	BinaryTree right;
	BinaryTree sibling;

	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}

	public BinaryTree(int d) {
		data = d;
		left = null;
		right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}

}