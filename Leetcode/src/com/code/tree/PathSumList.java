package com.code.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Return list of all paths whose sum is equal to given number.
 * @author thirunavukarasu
 *
 */
public class PathSumList {
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<Integer> path = new ArrayList<Integer>();
		pathSum(root, sum, path);
		return res;
	}

	public void pathSum(TreeNode root, int sum, List<Integer> path) {
		if (root == null)
			return;
		path.add(root.val);
		if (root.left == null && root.right == null && sum == root.val)
			res.add(new ArrayList<Integer>(path));
		else {
			pathSum(root.left, sum - root.val, path);
			pathSum(root.right, sum - root.val, path);
		}
		path.remove(path.size() - 1);
	}
}
