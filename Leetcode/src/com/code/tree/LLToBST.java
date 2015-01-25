package com.code.tree;


public class LLToBST {
	ListNode cur = null;

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		LLToBST l = new LLToBST();
		TreeNode r = l.sortedListToBST(a);
		l.inOrderTraversal(r);
	}

	public TreeNode sortedListToBST(ListNode head) {
		cur = head;
		return createBST(size(head));
	}

	public TreeNode createBST(int n) {
		if (n == 0)
			return null;
		TreeNode root = new TreeNode(0);
		root.left = createBST(n / 2);
		root.val = cur.val;
		cur = cur.next;
		root.right = createBST(n - n / 2 - 1);
		return root;
	}

	public int size(ListNode head) {
		ListNode cur = head;
		int c = 0;
		while (cur != null) {
			c++;
			cur = cur.next;
		}
		return c;
	}

	public void inOrderTraversal(TreeNode root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.val);
			inOrderTraversal(root.right);
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}