package com.code.linkedlist;

/**
 * Swap node pairs in linkedList
 * 
 * @author thirunavukarasu
 * 
 */
public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode cur = head, next = null, prev = null;
		while (cur != null && cur.next != null) {
			if (next == null)
				head = cur.next;
			next = cur.next.next;
			if (prev != null)
				prev.next = cur.next;
			cur.next.next = cur;
			cur.next = next;
			prev = cur;
			cur = next;
		}
		return head;
	}
}
