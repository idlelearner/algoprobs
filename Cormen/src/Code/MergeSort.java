package Code;

import java.util.Arrays;

/**
 * merge sort using recursion Complexity nlogn
 * 
 * @author Dhass
 * 
 */
public class MergeSort {
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int a[] = { 5, 3, -1, 4, 6 };
		m.mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	// merge sort using recursion
	public void mergeSort(int a[], int p, int r) {
		if (p < r) {
			int q = (int) Math.floor((p + r) / 2);
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			merge(a, p, q, r);
		}

	}

	public void merge(int a[], int p, int q, int r) {
		int b[] = new int[q - p + 1];
		int c[] = new int[r - q];
		for (int i = p, j = 0; i <= q; i++, j++)
			b[j] = a[i];
		for (int i = q + 1, j = 0; i <= r; i++, j++)
			c[j] = a[i];

		// combine the arrays into sorted single array
		int k = p;
		int i = 0, j = 0;
		while (k <= r) {
			if (i >= b.length) {
				a[k] = c[j];
				j++;
			} else if (j >= c.length) {
				a[k] = b[i];
				i++;
			} else if (b[i] < c[j]) {
				a[k] = b[i];
				i++;
			} else {
				a[k] = c[j];
				j++;
			}
			k++;
		}
	}

}
