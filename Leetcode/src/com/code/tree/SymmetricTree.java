package com.code.tree;

/**
 * Find if the given tree is symmetric i.e it is the mirror image of itself.
 * 
 * @author dhass
 *
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	public boolean isSymmetric(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if ((root1 == null && root2 != null)
				|| (root1 != null && root2 == null))
			return false;
		if (root1.val != root2.val)
			return false;
		return isSymmetric(root1.left, root2.right)
				&& isSymmetric(root1.right, root2.left);
	}
}
