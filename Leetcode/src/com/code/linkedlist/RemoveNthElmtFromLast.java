package com.code.linkedlist;

/**
 * Remove Nth last Elmt from the list.
 * 
 * @author thirunavukarasu
 * 
 */
public class RemoveNthElmtFromLast {

	public static void main(String[] args) {
		RemoveNthElmtFromLast r = new RemoveNthElmtFromLast();
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		ListNode head = r.removeNthFromEnd(a, 2);
		r.print(head);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode cur = head, nextPtr = null, prev = null;
		int i = 1;
		if (head == null || (head.next == null && n == 1))
			return null;
		while (cur != null) {
			if (i >= n) {
				prev = nextPtr;
				if (nextPtr == null)
					nextPtr = head;
				else
					nextPtr = nextPtr.next;
			}
			i++;
			cur = cur.next;
		}
		// If prev is null then the next ptr is in the first node so remove it.
		if (prev == null)
			return nextPtr.next;
		else if (prev != null && prev.next != null)
			prev.next = prev.next.next;
		return head;
	}

	public void print(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + " ");
		}
	}
}
