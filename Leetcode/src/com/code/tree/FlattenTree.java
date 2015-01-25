package com.code.tree;

/**
 * Flatten the binary tree to single linkedlist in place. Pre order traversal.
 * 
 * @author thirunavukarasu
 * 
 */
public class FlattenTree {
	TreeNode prev = null;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		FlattenTree f = new FlattenTree();
		f.flatten(root);
		f.printList(root);
	}

	public void flatten(TreeNode root) {
		if (root != null) {
			if (prev != null) {
				prev.right = root;
				prev.left = null;
			}
			prev = root;
			TreeNode rootRight = root.right;
			flatten(root.left);
			flatten(rootRight);
		}
	}

	public void printList(TreeNode root) {
		while (root != null) {
			System.out.println(root.val);
			root = root.right;
		}
	}
}
