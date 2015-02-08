package com.code.twoptrs;

/**
 * Find the amount of rain water that could be trapped
 * 
 * @author thirunavukarasu
 *
 */
public class TrapRainWater {
	public static void main(String[] args) {
		int a[] = { 4, 2, 3 };
		TrapRainWater t = new TrapRainWater();
		System.out.println(t.trap(a));
	}

	public int trap(int[] A) {
		if (A == null || A.length <= 1)
			return 0;
		int l = 0, r = A.length - 1;
		int val = 0;
		while (l < r) {
			if (A[l] <= A[l + 1])
				l++;
			else
				break;
		}
		while (l < r) {
			if (A[r - 1] >= A[r])
				r--;
			else
				break;
		}

		int left = 0, right = 0;
		while (l < r) {
			left = A[l];
			right = A[r];
			if (left < right) {
				while (l < r && left > A[++l]) {
					val += left - A[l];
				}
			} else {
				while (l < r && right > A[--r]) {
					val += right - A[r];
				}
			}
		}
		return val;
	}
}
