package code.sorting;

import java.util.Arrays;

/**
 * Quick sort - logic from cormen
 * 
 * @author Dhass
 * 
 */
public class QuickSort {

	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		int A[] = { 4, 6, -2, 13, 2, 8 ,14};
		q.quickSort(A, 0, A.length - 1);
		System.out.println(Arrays.toString(A));
	}

	public void quickSort(int A[], int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quickSort(A, p, q - 1);
			quickSort(A, q + 1, r);
		}
	}

	// partition the array give the position for pivot elmt
	int partition(int A[], int p, int r) {
		// choosing the last elmt as pivot
		int x = A[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (A[j] <= x) {
				i++;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		int temp = A[i + 1];
		A[i + 1] = A[r];
		A[r] = temp;
		return i + 1;
	}

	static void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
		
	}
}
