package code.fourfiftyfive;

import java.util.ArrayDeque;
import java.util.HashSet;

public class EasySequence {
	public static void main(String[] args) {
		EasySequence e = new EasySequence();
		int A[] = { 1, 2, 3 };
		int B[] = { 0, 7, 8, 5 };
		System.out.println(e.find(A, B));
	}

	public int find(int[] A, int[] B) {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		HashSet<Integer> h = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++)
			q.addLast(A[i]);
		int i = 0;
		while (true) {
			if (i < 0)
				return -1;
			if (q.size() == B.length) {
				if (prefixEqual((Object[]) q.toArray(), B))
					return i;
				int e = encode(q.toArray());
				if (h.contains(e))
					return -1;
				h.add(e);
				i++;
			}
			int n = getNextVal(q.toArray(), q.size() - A.length, q.size());
			if (q.size() == B.length)
				q.removeFirst();
			q.addLast(n);
		}
	}

	public int getNextVal(Object A[], int s, int e) {
		int v = 0;
		for (int i = s; i < e; i++)
			v += (Integer) A[i];
		return v % 10;
	}

	public int encode(Object A[]) {
		int c = 0;
		for (int i = 0; i < A.length; i++)
			c = (int) (c + Math.pow(10, i) * (Integer) A[i]);
		return c;
	}

	public boolean prefixEqual(Object A[], int B[]) {

		for (int i = 0; i < B.length; i++)
			if (B[i] != (Integer) A[i])
				return false;
		return true;
	}

}