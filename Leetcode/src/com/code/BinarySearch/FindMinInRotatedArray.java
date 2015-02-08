package com.code.BinarySearch;
public class FindMinInRotatedArray {

	public static void main(String[] args) {
		FindMinInRotatedArray f = new FindMinInRotatedArray();
		int a[] = { 1, 2, 2, 2, 0, 1, 1 };
		System.out.println(f.findMin(a));
	}

	public int findMin(int[] num) {
		return findMin(num, 0, num.length - 1);
	}

	public int findMin(int a[], int l, int h) {
		int mid = l + (h - l) / 2;
		if (l == h)
			return a[l];
		if (h - l <= 1) {
			if (a[l] < a[h])
				return a[l];
			else
				return a[h];
		}
		if (a[h] == a[l] && a[mid] == a[l])
			return findMin(a, l + 1, h);
		else if (a[h] < a[l] && a[mid] >= a[h]) {
			return findMin(a, mid, h);
		} else
			return findMin(a, l, mid);
	}
}
