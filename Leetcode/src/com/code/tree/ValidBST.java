package com.code.tree;

/**
 * Given a binary check if it is BST or not.
 * 
 * @author dhass
 *
 */
public class ValidBST {
	TreeNode prev = null;

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (!isValidBST(root.left))
			return false;
		if (prev != null && prev.val >= root.val)
			return false;
		prev = root;
		return isValidBST(root.right);
	}
}
