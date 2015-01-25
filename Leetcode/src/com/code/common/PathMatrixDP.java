package com.code.common;
/**
 * Find all possible paths in a grid DP
 * 
 * @author thiru022
 *
 */
public class PathMatrixDP {
	public static void main(String[] args) {
		PathMatrixDP p = new PathMatrixDP();
		int a[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		// int a[][] = { { 0, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 },
		// { 1, 1, 1, 0 } };
		System.out.println(p.uniquePathsWithObstacles(a));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int sol[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				if (m == 1)
					return 0;
			} else
				sol[i][0] = 1;
		}

		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] == 1) {
				if (n == 1)
					return 0;
			} else
				sol[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] != 1)
					sol[i][j] = sol[i - 1][j] + sol[i][j - 1];
			}
		}

		return sol[m - 1][n - 1];
	}
}
