package com.code.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Print the level order traversal in reverse order
 * 
 * @author thirunavukarasu
 * 
 */
public class BinaryLevelOrderReversal {

	public static void main(String[] args) {
		BinaryLevelOrderReversal b = new BinaryLevelOrderReversal();
		TreeNode root = new TreeNode(1);
		System.out.println(b.levelOrderBottom(root));
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
		if (root == null)
			return res;
		q.add(root);
		q.add(new TreeNode(Integer.MIN_VALUE));
		while (!q.isEmpty()) {
			TreeNode cur = q.pollFirst();
			if (cur.val == Integer.MIN_VALUE) {
				res.add(temp);
				temp = new ArrayList<Integer>();
				if (q.isEmpty())
					break;
				q.add(new TreeNode(Integer.MIN_VALUE));
			} else {
				temp.add(cur.val);
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}
		}

		List<List<Integer>> res2 = new ArrayList<List<Integer>>();
		for (int i = res.size() - 1; i >= 0; i--)
			res2.add(res.get(i));

		return res2;
	}
}
