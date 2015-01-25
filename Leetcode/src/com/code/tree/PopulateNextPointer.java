package com.code.tree;

public class PopulateNextPointer {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		root.next = null;
		TreeLinkNode nextLevel = root.left;
		TreeLinkNode prev = null, cur = root;
		while (cur.left != null) {
			cur.left.next = cur.right;
			if (prev != null && prev.next != null)
				prev.right.next = cur.left;
			if (cur.next == null) {
				cur = nextLevel;
				nextLevel = nextLevel.left;
				prev = null;
			} else {
				prev = cur;
				cur = cur.next;
			}
		}
	}
}
