package code.sorting;

import java.util.Arrays;

/**
 * Heap Sort
 * 
 * @author Dhass
 * 
 */
public class Heapsort {

	public static void main(String[] args) {
		Heapsort h = new Heapsort();
		int a[] = { 2, 7, 2,1, 4, 6, 3 };
		h.heapsort(a);
		System.out.println(Arrays.toString(a));
	}

	// Heapsort
	public void heapsort(int a[]) {
		int n = a.length;
		buildMaxHeap(a, n);
		for (int i = a.length - 1; i > 0; i--) {
			int t = a[0];
			a[0] = a[i];
			a[i] = t;
			n = n - 1;
			maxHeapify(a, 0, n);
		}
	}

	// Max heapify the array
	public void maxHeapify(int a[], int i, int n) {
		int l = getLeft(i);
		int r = getRight(i);
		int largest = i;
		if (l < n && a[l] > a[i])
			largest = l;
		if (r < n && a[r] > a[largest])
			largest = r;
		if (i != largest) {
			int t = a[i];
			a[i] = a[largest];
			a[largest] = t;
			maxHeapify(a, largest, n);
		}
	}

	// Build the max heap
	public void buildMaxHeap(int a[], int n) {
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
