package com.code.common;

public class FindPeak {
	public static void main(String[] args) {
		int a[] = { 3, 2, 1 };
		FindPeak f = new FindPeak();
		System.out.println(f.findPeakElement(a));
	}

	public int findPeakElement(int[] num) {
		if (num.length == 1)
			return 0;
		return findPeak(num, 0, num.length - 1);
	}

	public int findPeak(int a[], int l, int h) {
		if (l > h)
			return -1;
		int mid = l + (h - l) / 2;
		if (mid != a.length - 1 && mid != 0 && a[mid] > a[mid + 1]
				&& a[mid] > a[mid] - 1)
			return mid;
		if (mid == 0 && a[mid] > a[mid + 1])
			return mid;
		if (mid == a.length - 1 && a[mid] > a[mid - 1])
			return mid;
		if (a[mid] < a[mid + 1])
			return findPeak(a, mid + 1, h);
		else
			return findPeak(a, l, mid - 1);
	}
}
