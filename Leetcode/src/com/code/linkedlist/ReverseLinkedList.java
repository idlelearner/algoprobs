package com.code.linkedlist;

/**
 * Reverse the given linkedList.
 * 
 * @author thirunavukarasu
 * 
 */
public class ReverseLinkedList {
	public ListNode reverse(ListNode head) {
		ListNode cur = head;
		if (cur == null || cur.next == null)
			return cur;
		ListNode prev = null, next = cur;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}
}
