package com.code.tree;

/**
 * Sum the root to leaf digit values.
 * 
 * @author thirunavukarasu
 * 
 */
public class SumNumbers {
	int res = 0;

	public int sumNumbers(TreeNode root) {
		sumNumbers(root, 0);
		return res;
	}

	public void sumNumbers(TreeNode root, int n) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				res = res + (n * 10 + root.val);
			} else {
				sumNumbers(root.left, (n * 10 + root.val));
				sumNumbers(root.right, (n * 10 + root.val));
			}
		}
	}
}
