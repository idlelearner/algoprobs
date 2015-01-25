package com.code.linkedlist;

/**
 * Find intersextion in a given 2 linked lists
 * 
 * @author thirunavukarasu
 * 
 */
public class FindIntersection {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int l1 = findLength(headA);
		int l2 = findLength(headB);
		if (l1 < l2) {
			ListNode t = headA;
			headA = headB;
			headB = t;
		}

		int lapse = (int) Math.abs(l1 - l2);
		ListNode curA = headA, curB = headB;
		int n = 0;
		while (curA != null) {
			if (curA == curB)
				return curA;
			curA = curA.next;
			if (n >= lapse)
				curB = curB.next;
			n++;
		}

		return null;
	}

	public int findLength(ListNode head) {
		if (head == null)
			return 0;
		ListNode cur = head;
		int c = 0;
		while (cur != null) {
			c++;
			cur = cur.next;
		}
		return c;
	}
}
