package code;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(10,
				new MinHeapComparator());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10,
				new MaxHeapComparator());
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int v = r.nextInt(100);
			System.out.print(v + " ");
			heap.add(v);
			minHeap.add(v);
			maxHeap.add(v);
		}
		System.out.println();
		System.out.println("Min Heap : " + heap.peek());
		System.out.println("Min Heap : " + minHeap.peek());
		System.out.println("Max Heap : " + maxHeap.peek());
	}
}

class MaxHeapComparator implements Comparator<Integer> {
	public int compare(Integer a, Integer b) {
		return a > b ? -1 : 1;
	}
}

class MinHeapComparator implements Comparator<Integer> {
	public int compare(Integer a, Integer b) {
		return a < b ? -1 : 1;
	}
}
