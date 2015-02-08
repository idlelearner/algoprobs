package com.code.linkedlist;

import com.code.linkedlist.ListNode;

/**
 * Reverse the linkedlist between the given location m,n
 * 
 * @author thirunavukarasu
 *
 */
public class ReverseBetween {
	public class Solution {
		public ListNode reverseBetween(ListNode head, int m, int n) {
			ListNode startPrev = null, start = null, end = null, endNext = null;
			ListNode cur = head;
			int count = 1;
			while (cur != null) {
				if (count <= m) {
					startPrev = start;
					start = cur;
				}
				if (count == n) {
					end = cur;
					endNext = cur.next;
					break;
				}
				cur = cur.next;
				count++;
			}

			if (startPrev != null)
				startPrev.next = end;
			cur = start;
			ListNode prev = endNext, next = null;
			while (cur != endNext) {
				next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}
			if (m == 1)
				return end;
			else
				return head;
		}
	}
}
