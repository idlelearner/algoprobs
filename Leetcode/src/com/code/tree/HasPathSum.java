package com.code.tree;

/**
 * Find if there exists a path whose sum equals to target.
 * @author thirunavukarasu
 *
 */
public class HasPathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.val == sum)
			return true;
		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}
}
