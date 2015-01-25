package com.code.BinarySearch;

/**
 * Find a element in a sorted rotated array.
 * 
 * @author thirunavukarasu
 * 
 */
public class FindInRotatedArray {
	public int search(int[] A, int target) {
		return search(A, target, 0, A.length - 1);
	}

	public int search(int A[], int target, int l, int h) {
		if (l > h)
			return -1;
		int mid = l + (h - l) / 2;
		if (A[mid] == target)
			return mid;
		else if (A[l] <= A[mid]) {
			if (A[mid] > target && A[l] <= target)
				return search(A, target, l, mid - 1);
			else
				return search(A, target, mid + 1, h);
		} else {
			if (A[mid] < target && A[h] >= target)
				return search(A, target, mid + 1, h);
			else
				return search(A, target, l, mid - 1);
		}
	}
}
