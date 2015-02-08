package com.code.backtracking;
/**
 * Print the number of paths in a matrix Backtracking
 * 
 * @author thiru022
 *
 */
public class PathMatrix {

	public static void main(String[] args) {
		PathMatrix p = new PathMatrix();
		// int a[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int a[][] = { { 0, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 },
				{ 1, 1, 1, 0 } };
		System.out.println(p.uniquePathsWithObstacles(a));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int sol[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
		int n = solveGrid(obstacleGrid, sol, 0, 0);
		return n;
	}

	public int solveGrid(int[][] obstacleGrid, int[][] sol, int curR, int curC) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int v = 0;
		if (curR == m - 1 && curC == n - 1) {
			sol[curR][curC] = 1;
			printMaze(sol);
			return 1;
		} else {
			if (isSafe(obstacleGrid, sol, curR, curC)) {
				sol[curR][curC] = 1;
				v += solveGrid(obstacleGrid, sol, curR + 1, curC);
				v += solveGrid(obstacleGrid, sol, curR, curC + 1);
				sol[curR][curC] = 0;
			}
		}
		return v;
	}

	public boolean isSafe(int[][] obstacleGrid, int[][] sol, int x, int y) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (x < 0 || x >= m || y < 0 || y >= n || obstacleGrid[x][y] == 1
				|| obstacleGrid[x][y] == 1)
			return false;
		return true;
	}

	public void printMaze(int sol[][]) {
		int m = sol.length;
		int n = sol[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println(" ");
	}

}
