package com.code.linkedlist;

public class PartitionList {

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		PartitionList p = new PartitionList();
		ListNode head = p.partition(a, 2);
		p.print(head);
	}

	public ListNode partition(ListNode head, int x) {
		ListNode newNode = null, cur = head, prev = null;
		if (head == null || head.next == null)
			return head;
		while (cur != null) {
			if (cur.val >= x) {
				if (newNode == null)
					newNode = cur;
				else
					newNode.next = cur;
				if (prev != null)
					prev = prev.next = cur.next;
				else
					head = head.next;
			}
			prev = cur;
			cur = cur.next;
		}
		prev.next = newNode;
		return head;
	}

	public void print(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + " ");
		}
	}
}
