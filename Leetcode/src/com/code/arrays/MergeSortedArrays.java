package com.code.arrays;
public class MergeSortedArrays {
	/**
	 * Merge two sorted arrays A, B into one sorted array A 
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
	public void merge(int A[], int m, int B[], int n) {
		int l1 = m - 1, l2 = n - 1;
		for (int i = m + n - 1; i >= 0; i--) {
			if (l1 >= 0 && l2 >= 0) {
				if (A[l1] > B[l1]) {
					A[i] = A[l1];
					l1--;
				} else {
					A[i] = B[l2];
					l2--;
				}
			} else if (l1 < 0) {
				A[i] = B[l2];
				l2--;
			} else {
				break;
			}
		}
	}
}