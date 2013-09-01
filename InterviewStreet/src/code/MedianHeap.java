package code;

import java.util.ArrayList;
import java.util.Scanner;

public class MedianHeap {
	public static void main(String args[]) {
		// helpers for input/output
		Scanner in = new Scanner(System.in);
		int N;
		N = in.nextInt();

		String s[] = new String[N];
		int x[] = new int[N];
		for (int i = 0; i < N; i++) {
			s[i] = in.next();
			x[i] = in.nextInt();
		}

		ArrayList<Integer> minHeap = new ArrayList<Integer>();
		ArrayList<Integer> maxHeap = new ArrayList<Integer>();
		int size = 0;
		double median = 0.0;
		MedianHeap m = new MedianHeap();
		for (int i = 0; i < N; i++) {
			size = minHeap.size() + maxHeap.size();
			if (s[i].equals("a")) {
				if (size == 0) {
					minHeap.add(x[i]);
					System.out.println(x[i]);
					median = x[i];
					continue;
				} else {
					if (x[i] > median) {
						minHeap.add(x[i]);
						m.buildMinHeap(minHeap, minHeap.size());
						m.balanceHeaps(maxHeap, minHeap);
					} else if (x[i] < median) {
						maxHeap.add(x[i]);
						m.buildMaxHeap(maxHeap, maxHeap.size());
						m.balanceHeaps(maxHeap, minHeap);
					} else {
						minHeap.add(x[i]);
						m.buildMinHeap(minHeap, minHeap.size());
						m.balanceHeaps(maxHeap, minHeap);
					}
				}

				median = m.getMedian(maxHeap, minHeap);
			} else if (s[i].equals("r")) {
				// implement remove
				if (minHeap.contains(new Integer(x[i]))
						|| maxHeap.contains(new Integer(x[i]))) {
					if (minHeap.contains(x[i])) {
						minHeap.remove(new Integer(x[i]));
						m.buildMinHeap(minHeap, minHeap.size());
						m.balanceHeaps(maxHeap, minHeap);
					} else {
						maxHeap.remove(new Integer(x[i]));
						m.buildMaxHeap(maxHeap, maxHeap.size());
						m.balanceHeaps(maxHeap, minHeap);
					}
					median = m.getMedian(maxHeap, minHeap);
				} else {
					System.out.println("Wrong!");
				}
			}
		}
	}

	public double getMedian(ArrayList<Integer> maxHeap,
			ArrayList<Integer> minHeap) {
		if (minHeap.isEmpty() && maxHeap.isEmpty()) {
			System.out.println("Wrong!");
			return 0.0;
		}
		double medianElmt = 0.0;
		if (minHeap.size() > maxHeap.size()) {
			System.out.println(minHeap.get(0));
			medianElmt = minHeap.get(0);
		} else {
			medianElmt = (double) (maxHeap.get(0) + minHeap.get(0)) / 2;
			System.out.println(medianElmt);
		}
		return medianElmt;
	}

	public void balanceHeaps(ArrayList<Integer> maxHeap,
			ArrayList<Integer> minHeap) {
		while (true) {
			if (minHeap.size() == maxHeap.size()
					|| (minHeap.size() - maxHeap.size()) == 1)
				break;
			if (minHeap.size() > maxHeap.size()
					&& minHeap.size() - maxHeap.size() >= 2) {
				maxHeap.add(minHeap.get(0));
				minHeap.remove(minHeap.get(0));
			} else if (maxHeap.size() > minHeap.size()) {
				minHeap.add(maxHeap.get(0));
				maxHeap.remove(maxHeap.get(0));
			}
			buildMaxHeap(maxHeap, maxHeap.size());
			buildMinHeap(minHeap, minHeap.size());
		}
		return;
	}

	// Min heapify the array
	public void minHeapify(ArrayList<Integer> a, int i, int n) {
		int l = getLeft(i);
		int r = getRight(i);
		int largest = i;
		if (l < n && a.get(l) < a.get(i))
			largest = l;
		if (r < n && a.get(r) < a.get(largest))
			largest = r;
		if (i != largest) {
			int t = a.get(i);
			a.set(i, a.get(largest));
			a.set(largest, t);
			maxHeapify(a, largest, n);
		}
	}

	// Build the max heap
	public void buildMinHeap(ArrayList<Integer> a, int n) {
		if (n == 0)
			return;
		for (int i = n / 2; i >= 0; i--)
			minHeapify(a, i, n);
	}

	// Max heapify the array
	public void maxHeapify(ArrayList<Integer> a, int i, int n) {
		int l = getLeft(i);
		int r = getRight(i);
		int largest = i;
		if (l < n && a.get(l) > a.get(i))
			largest = l;
		if (r < n && a.get(r) > a.get(largest))
			largest = r;
		if (i != largest) {
			int t = a.get(i);
			a.set(i, a.get(largest));
			a.set(largest, t);
			maxHeapify(a, largest, n);
		}
	}

	// Build the max heap
	public void buildMaxHeap(ArrayList<Integer> a, int n) {
		if (n == 0)
			return;
		for (int i = n / 2; i >= 0; i--)
			maxHeapify(a, i, n);
	}

	public int getLeft(int i) {
		return 2 * i;
	}

	public int getRight(int i) {
		return 2 * i + 1;
	}

}
