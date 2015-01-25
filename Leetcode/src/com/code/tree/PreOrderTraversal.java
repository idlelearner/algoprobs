package com.code.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Preorder traversal of a tree.
 * 
 * @author thirunavukarasu
 * 
 */
public class PreOrderTraversal {
	List<Integer> preOrder = new ArrayList<Integer>();

	public List<Integer> preorderTraversal(TreeNode root) {
		if (root != null) {
			preOrder.add(root.val);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
		return preOrder;
	}
}
