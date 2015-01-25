package com.code.search;

/**
 * Remove duplicates(elements greater than 2 occurence) in a sorted array
 * @author thirunavukarasu
 *
 */
public class RemoveDuplicatesWithTwoAllowed {
	public int removeDuplicates(int[] A) {
		if (A.length == 1)
			return 1;
		int l = 0;
		for (int i = 0; i < A.length; i++) {
			A[l] = A[i];
			l++;
			// Find the last occurence of the current character and move the
			// ptr.
			int e = findLastOccurence(A, i, A.length - 1, A[i]);
			if ((e - i) >= 1) {
				A[l] = A[i + 1];
				l++;
				i = e;
			}
		}
		return l;
	}

	// Binary search to find the last occurence of the element.
	public int findLastOccurence(int A[], int l, int h, int elem) {
		if (l > h)
			return -1;
		if (l == h)
			return l;
		int m = l + (h - l) / 2;
		if ((m == A.length - 1 && A[m] == elem)
				|| (A[m] == elem && A[m + 1] != elem))
			return m;
		else if (A[m] <= elem)
			return findLastOccurence(A, m + 1, h, elem);
		else
			return findLastOccurence(A, l, m - 1, elem);
	}
}
