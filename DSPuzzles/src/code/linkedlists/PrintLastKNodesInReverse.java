package code.linkedlists;

public class PrintLastKNodesInReverse {
	int count;

	public static void main(String[] args) {
		PrintLastKNodesInReverse p = new PrintLastKNodesInReverse();
		LinkedList cur = new LinkedList();
		LinkedList head = cur;
		int a[] = { 1, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = 0; i < a.length; i++) {
			cur.data = a[i];
			if (i == a.length - 1) {
				cur.next = null;
			} else {
				cur.next = new LinkedList();
				cur = cur.next;
			}
		}
		p.printLastNodesinReverse(head, 4);
	}

	public void printLastNodesinReverse(LinkedList cur, int k) {
		if (cur != null) {
			printLastNodesinReverse(cur.next, k);
			count++;
			if (count <= k)
				System.out.println(cur.data);
		}
	}
}

class LinkedList {
	int data;
	LinkedList next;
}
