package code.arrays;

import java.util.Arrays;

public class PartitionQSort {
	public static void main(String[] args) {
		int a[] = { 4, 3, 7, 5, 1, 3, 2, 3 };
		PartitionQSort p = new PartitionQSort();
		System.out.println(Arrays.toString(p.partition(a, a.length - 1)));
	}

	public int[] partition(int a[], int pivotIndex) {
		int x = a[pivotIndex];
		int small = 0, eq = 0, large = a.length - 1;
		while (eq <= large) {
			if (a[eq] < x) {
				int t = a[eq];
				a[eq] = a[small];
				a[small] = t;
				eq++;
				small++;
			} else if (a[eq] == x)
				++eq;
			else {
				int t = a[eq];
				a[eq] = a[large];
				a[large] = t;
				large--;
			}
		}
		return a;
	}
}
