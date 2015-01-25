package com.code.search;

/**
 * Find the position of an element to insert in sorted array.
 * 
 * @author thirunavukarasu
 * 
 */
public class SearchInsert {
	public int searchInsert(int[] A, int target) {
		return search(A, target, 0, A.length - 1);
	}

	public int search(int[] A, int target, int l, int h) {
		if (target > A[h])
			return h + 1;
		if (target < A[l])
			return l;
		int m = l + (h - l) / 2;
		if (A[m] == target)
			return m;
		else if (A[m] > target)
			return search(A, target, l, m - 1);
		else
			return search(A, target, m + 1, h);
	}
}
