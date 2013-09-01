package code.dynamicprogramming;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/archives/23245
 */
class Range {
	int a;
	int b;

	public Range(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class MaxIntervalChain {
	public static void main(String[] args) {
		Range[] a = { new Range(5, 24), new Range(27, 40), new Range(15, 25),
				new Range(50, 60) };
		MaxIntervalChain m = new MaxIntervalChain();
		System.out.println(m.maxInterval(a));
	}

	public int maxInterval(Range[] a) {
		int n = a.length;
		// Sort the ranges
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (a[i].a > a[j].a) {
					Range t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		}

		// Similar to LIS - Compare the second of finalized sequence to the
		// first element of next
		int maxIn[] = new int[n];
		Arrays.fill(maxIn, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < i; j++) {
				if (a[i].a > a[j].b && maxIn[i] < maxIn[j] + 1)
					maxIn[i] = maxIn[j] + 1;
			}
		}

		// find the maximum chain
		int max = 0;
		for (int i = 0; i < n; i++)
			if (max < maxIn[i])
				max = maxIn[i];

		return max;
	}
}
