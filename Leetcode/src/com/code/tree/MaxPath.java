package com.code.tree;

/**
 * Find the max path which is based on the node value in the given tree
 * Eg: Like diameter of the tree.
 * @author dhass
 *
 */
public class MaxPath {
	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		maxPath(root);
		return maxSum;
	}

	public int maxPath(TreeNode root) {
		if (root == null)
			return 0;
		int l = maxPath(root.left);
		int r = maxPath(root.right);
		l = l > 0 ? l : 0;
		r = r > 0 ? r : 0;
		maxSum = Math.max(maxSum, l + r + root.val);
		return Math.max(l, r) + root.val;
	}
}
