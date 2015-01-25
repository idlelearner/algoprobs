package com.code.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Print the level order traversal in zigzag order.
 * 
 * @author thirunavukarasu
 * 
 */
public class BinaryTreeLevelOrderZigZagTreaversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		boolean odd = true;
		ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
		if (root == null)
			return res;
		q.add(root);
		q.add(new TreeNode(Integer.MIN_VALUE));
		while (!q.isEmpty()) {
			TreeNode cur = q.pollFirst();
			if (cur.val == Integer.MIN_VALUE) {
				if (odd) {
					res.add(temp);
					odd = false;
				} else {
					odd = true;
					List<Integer> t = new ArrayList<Integer>();
					for (int i = temp.size() - 1; i >= 0; i--)
						t.add(temp.get(i));
					res.add(t);
				}
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

		return res;
	}
}
