package com.code.tree;

/**
 * Check if the given tree is balanced or not.
 * 
 * @author thirunavukarasu
 * 
 */
public class IsTreeBalanced {
	boolean balanced = true;

	public boolean isBalanced(TreeNode root) {
		checkBalanced(root);
		return balanced;
	}

	public int checkBalanced(TreeNode root) {
		if (root == null)
			return 0;
		else {
			int l = checkBalanced(root.left);
			int r = checkBalanced(root.right);

			if (Math.abs(l - r) > 1)
				balanced = false;

			return 1 + Math.max(l, r);
		}
	}
}
