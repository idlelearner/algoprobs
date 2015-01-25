package com.code.linkedlist;

/**
 * Add Two numbers in the given linkedlist.
 * 
 * @author thirunavukarasu
 * 
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return l1;
		ListNode l3 = null, l3head = null, t = null;
		int c = 0;
		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				t = new ListNode((l1.val + l2.val + c) % 10);
				c = (int) (l1.val + l2.val + c) / 10;
				l1 = l1.next;
				l2 = l2.next;
			} else if (l2 != null) {
				t = new ListNode((l2.val + c) % 10);
				c = (int) (l2.val + c) / 10;
				l2 = l2.next;
			} else {
				t = new ListNode((l1.val + c) % 10);
				c = (int) (l1.val + c) / 10;
				l1 = l1.next;
			}

			if (l3 == null) {
				l3 = t;
				l3head = t;
			} else {
				l3.next = t;
				l3 = l3.next;
			}
		}

		if (c != 0) {
			t = new ListNode(c);
			l3.next = t;
		}

		return l3head;
	}
}
