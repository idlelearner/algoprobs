package com.code.common;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		ListNode head = null, cur = null;
		if (lists.isEmpty())
			return head;
		PriorityQueue<ListNode> q = new PriorityQueue<>(lists.size(),
				new Comparator<ListNode>() {
					@Override
					public int compare(ListNode l1, ListNode l2) {
						return Integer.compare(l1.val, l2.val);
					}
				});

		for (int i = 0; i < lists.size(); i++) {
			ListNode l = lists.get(i);
			if (l != null)
				q.add(l);
		}

		if (q.isEmpty())
			return head;

		head = q.poll();
		cur = head;
		if (head.next != null)
			q.add(head.next);
		while (!q.isEmpty()) {
			cur.next = q.poll();
			cur = cur.next;
			if (cur.next != null)
				q.add(cur.next);
		}

		return head;
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
