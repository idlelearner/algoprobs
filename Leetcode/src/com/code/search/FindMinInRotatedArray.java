package com.code.search;

/**
 * Find minimum in a rotated array containing duplicates.
 * 
 * @author dhass
 *
 */
public class FindMinInRotatedArray {
	public int findMin(int[] num) {
		return findMin(num, 0, num.length - 1);
	}

	public int findMin(int a[], int l, int h) {
		if ((h - l) <= 1 && a[l] <= a[h])
			return a[l];
		int mid = l + (h - l) / 2;
		if (a[mid] == a[l] && a[mid] == a[h]) {
			return findMin(a, l + 1, h);
		} else if (a[mid] > a[h]) {
			return findMin(a, mid + 1, h);
		} else {
			return findMin(a, l, mid);
		}
	}
}
