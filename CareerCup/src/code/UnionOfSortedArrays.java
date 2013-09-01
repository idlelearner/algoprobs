package code;

import java.util.Arrays;

public class UnionOfSortedArrays {
	public static void main(String[] args) {
		UnionOfSortedArrays u = new UnionOfSortedArrays();
		int a[] = { 1, 5, 6, 8, 9 };
		int b[] = { 2, 5, 6, 9, 12 };
		System.out.println(Arrays.toString(u.unionOfSortedArrays(a, b)));
	}

	public int[] unionOfSortedArrays(int a[], int b[]) {
		int al = a.length, bl = b.length;
		int c[] = new int[al + bl];
		int i = 0, j = 0, k = 0;
		while (i <= al - 1 || j <= bl - 1) {
			if (i < al && j < bl) {
				//compare a and b and insert
				if (a[i] < b[j]) {
					if (k == 0 || c[k - 1] != a[i]) {
						c[k] = a[i];
						k++;
						i++;
					} else
						i++;
				} else {
					if (k == 0 || c[k - 1] != b[j]) {
						c[k] = b[j];
						k++;
						j++;
					} else
						j++;
				}

			}
			
			// Fill the b array in c
			if (i > al - 1 && j <= bl - 1) {
				if (k == 0 || c[k - 1] != b[j]) {
					c[k] = b[j];
					k++;
					j++;
				} else
					j++;
			}
			// Fill the a array in c
			if (j > bl - 1 && i <= al - 1) {
				if (k == 0 || c[k - 1] != a[i]) {
					c[k] = a[i];
					k++;
					i++;
				} else
					i++;
			}

		}
		// if (k != al + bl - 1)
		// c[k + 1] = '\n';
		return c;
	}
}
