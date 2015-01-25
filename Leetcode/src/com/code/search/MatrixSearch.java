package com.code.search;

/**
 * Search for a element in a row and column sorted matrix Left down approach
 * 
 * @author dhass
 *
 */
public class MatrixSearch {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int l = m * n;
		int i = 0, j = n - 1, k = 0;
		while (k < l) {
			if (matrix[i][j] == target)
				return true;
			if (matrix[i][j] > target)
				j--;
			else
				i++;
			if (i >= m || j < 0)
				return false;
			k++;
		}
		return false;
	}
}
