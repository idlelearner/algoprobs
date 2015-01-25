package com.code.linkedlist;

/**
 * Create new linkedlist from old randomptrlist Error for : {-1,1,#,#}
 * 
 * @author thirunavukarasu
 * 
 */
public class CopyRandomPtrs {

	public static void main(String[] args) {
		CopyRandomPtrs c = new CopyRandomPtrs();
		RandomListNode head = new RandomListNode(-1);
		head.next = new RandomListNode(-1);
		head.random = head.next;
		RandomListNode newhead = c.copyRandomList(head);
		c.print(newhead);
	}

	public RandomListNode copyRandomList(RandomListNode head) {

		RandomListNode cur = head;
		if (cur == null)
			return cur;

		// Create new nodes next to current nodes.
		while (cur != null) {
			RandomListNode t = cur.next;
			cur.next = new RandomListNode(cur.label);
			cur.next.next = t;
			cur = t;
		}

		RandomListNode headnew = head.next;
		RandomListNode cur1 = headnew;
		cur = head;
		// populate random ptr
		while (cur != null) {
			cur1.random = cur.random == null ? null : cur.random.next;
			cur = cur.next.next;
			if (cur1.next != null)
				cur1 = cur1.next.next;
		}

		// split the lists
		cur = head;
		cur1 = headnew;
		while (cur != null) {
			cur.next = cur.next.next;
			cur = cur.next;
			if (cur1.next != null) {
				cur1.next = cur1.next.next;
				cur1 = cur1.next;
			}

		}

		return headnew;
	}

	public void print(RandomListNode head) {
		if (head != null) {
			System.out.println(head.label);
			print(head.next);
		}
	}

	// HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
	//
	// public RandomListNode copyRandomList(RandomListNode head) {
	// RandomListNode cur = head, newHead = null, prev = null, curNew = null;
	// if (cur == null)
	// return cur;
	// prev = null;
	// while (cur != null) {
	// RandomListNode newNode = new RandomListNode(cur.label);
	// if (prev != null)
	// prev.next = newNode;
	// else
	// newHead = newNode;
	// map.put(cur, newNode);
	// prev = cur;
	// cur = cur.next;
	// }
	//
	// cur = head;
	// curNew = newHead;
	//
	// while (cur != null) {
	// if (cur.random == null)
	// curNew.random = null;
	// else {
	// RandomListNode t = map.get(cur.random);
	// curNew.random = t;
	// }
	// cur = cur.next;
	// curNew = curNew.next;
	// }
	//
	// return newHead;
	// }
}

// Definition for singly-linked list with a random pointer.
class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}
