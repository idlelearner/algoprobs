package com.code.tree;

/**
 * Find the minimum height in the given Binary Tree.
 * 
 * @author dhass
 *
 */
public class MinDepthInTree {
	int minHeight = Integer.MAX_VALUE;

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		minDepth(root, 1);
		return minHeight;
	}

	public void minDepth(TreeNode root, int height) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				if (minHeight > height)
					minHeight = height;
			} else {
				minDepth(root.left, height + 1);
				minDepth(root.right, height + 1);
			}
		}
	}
}
