package com.code.tree;

public class RecoverTree {
	boolean isFirst = false;
	TreeNode prev = null;
	TreeNode firstInCorrectNode = null;

	public static void main(String[] args) {
		RecoverTree r = new RecoverTree();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(-1);
		r.printInOrder(root);
		r.recoverTree(root);
		System.out.println("");
		r.printInOrder(root);
	}

	public void recoverTree(TreeNode root) {
		if (root != null) {
			recoverTree(root.left);
			if (prev != null && prev.val > root.val) {
				if (isFirst) {
					swapValues(firstInCorrectNode, root);
					return;
				} else {
					firstInCorrectNode = prev;
					isFirst = true;
					if (root.right == null) {
						swapValues(root, prev);
					}
				}
			}
			prev = root;
			recoverTree(root.right);
		}
	}

	public void swapValues(TreeNode root1, TreeNode root2) {
		int t = root1.val;
		root1.val = root2.val;
		root2.val = t;
	}

	public void printInOrder(TreeNode root) {
		if (root != null) {
			printInOrder(root.left);
			System.out.print(root.val + " ");
			printInOrder(root.right);
		}
	}

}
