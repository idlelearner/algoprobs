package com.code.common;
import java.util.ArrayDeque;

/**
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-
 * ii/
 * Time limit exceeded.
 * Solved for full binary tree. check code.
 * @author thiru022
 *
 */
public class PopulateNextPtr {
	public static void main(String[] args) {

	}

	public class Solution {

		public void connect(TreeLinkNode root) {
			ArrayDeque<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
			if (root == null)
				return;
			TreeLinkNode nullRoot = new TreeLinkNode(Integer.MIN_VALUE);
			TreeLinkNode prev = root;
			queue.add(root);
			queue.add(nullRoot);
			while (!queue.isEmpty()) {
				TreeLinkNode temp = queue.poll();
				if (temp.val == Integer.MIN_VALUE) {
					if (!queue.isEmpty())
						break;
					queue.add(nullRoot);
				}
				if (prev.val != nullRoot.val)
					prev.next = temp;
				prev = temp;
				TreeLinkNode left = temp.left;
				if (left != null)
					queue.add(left);
				TreeLinkNode right = temp.right;
				if (right != null)
					queue.add(right);
			}
		}
	}
}

// Definition for binary tree with next pointer.
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
