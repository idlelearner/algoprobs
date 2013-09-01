package code.evernote;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopFour {
	public static void main(String[] args) {
		// helpers for input/output
		Scanner in = new Scanner(System.in);
		int N;
		N = in.nextInt();

		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, max4 = Integer.MIN_VALUE;
		int curElmt = 0;
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			curElmt = in.nextInt();
			a[i] = curElmt;
			if (curElmt > max4) {
				if (curElmt > max1) {
					int t = max1;
					max1 = curElmt;
					curElmt = t;
				}
				if (curElmt > max2) {
					int t = max2;
					max2 = curElmt;
					curElmt = t;
				}
				if (curElmt > max3) {
					int t = max3;
					max3 = curElmt;
					curElmt = t;
				}
				if (curElmt > max4) {
					int t = max4;
					max4 = curElmt;
					curElmt = t;
				}
			}
		}
		if (max1 != Integer.MIN_VALUE)
			System.out.println(max1);
		if (max2 != Integer.MIN_VALUE)
			System.out.println(max2);
		if (max3 != Integer.MIN_VALUE)
			System.out.println(max3);
		if (max4 != Integer.MIN_VALUE)
			System.out.println(max4);

		System.out.println(Arrays.toString(findTopKHeap(a, 4)));
	}

	public static int[] findTopKHeap(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : arr) {
			if (pq.size() < k)
				pq.add(x);
			else if (pq.peek() < x) {
				pq.poll();
				pq.add(x);
			}
		}
		int[] res = new int[k];
		for (int i = 0; i < k; i++)
			res[i] = pq.poll();
		return res;

	}
}
