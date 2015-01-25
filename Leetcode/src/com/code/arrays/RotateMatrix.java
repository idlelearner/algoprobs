package com.code.arrays;

/**
 * Rotate the matrix by 90 degree Not correct - Need to fix it.
 * 
 * @author thirunavukarasu
 * 
 */
public class RotateMatrix {
	public void rotate(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (m <= 1)
			return;
		int i1 = 0, j1 = 0, i2 = 0, j2 = n - 1;
		int r = 0;
		while ((m - r) > m / 2) {
			i1 = 0 + r;
			j1 = 0 + r;
			i2 = 0 + r;
			j2 = n - 1 - r;
			while (j1 < n - 1 - r) {
				swap(matrix, i1, j1, i2, j2);
				j1++;
				i2++;
			}

			i2 = m - 1 - r;
			j2 = n - 1 - r;
			i1 = r;
			j1 = r;
			while (j1 < n - 1 - r) {
				swap(matrix, i1, j1, i2, j2);
				j1++;
				j2--;
			}

			i2 = r;
			j2 = m - 1 - r;
			i1 = r;
			j1 = r;
			while (i2 > r) {
				swap(matrix, i1, j1, i2, j2);
				j1++;
				i2--;
			}
			r++;
		}
	}

	public void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
		int t = matrix[i1][j1];
		matrix[i1][j1] = matrix[i2][j2];
		matrix[i2][j2] = t;
	}
}
