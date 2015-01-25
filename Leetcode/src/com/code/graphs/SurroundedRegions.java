package com.code.graphs;

import java.util.Stack;

/**
 * Change 'O' to 'X' if it is surrounded by 'X' and not borders
 * 
 * @author dhass
 *
 */
public class SurroundedRegions {

	public static void main(String[] args) {
		SurroundedRegions s = new SurroundedRegions();
		char a[][] = { { 'X', 'O' }, { 'O', 'X' } };
		s.solve(a);

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println("");
		}
	}

	public void solve(char[][] board) {
		int m = board.length;
		if (m <= 1)
			return;

		int n = board[0].length;
		if (n <= 1)
			return;

		int i = 0, j = 0;
		for (i = 0; i < m; i++) {
			if (board[i][j] == 'O')
				MarkItUnchanged(board, i, j);
		}

		j = n - 1;
		for (i = 0; i < m; i++) {
			if (board[i][j] == 'O')
				MarkItUnchanged(board, i, j);
		}

		i = 0;
		for (j = 0; j < n; j++) {
			if (board[i][j] == 'O')
				MarkItUnchanged(board, i, j);
		}

		i = m - 1;
		for (j = 0; j < n; j++) {
			if (board[i][j] == 'O')
				MarkItUnchanged(board, i, j);
		}

		// Change the values.
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (board[i][j] == '$')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}

	// Border characters need not be changed.
	public void MarkItUnchanged(char c[][], int i, int j) {
		Stack<Point> s = new Stack<Point>();
		int x[] = { 0, 1, 0, -1 };
		int y[] = { -1, 0, 1, 0 };
		int m = c.length;
		int n = c[0].length;
		s.push(new Point(i, j));
		c[i][j] = '$';
		while (!s.isEmpty()) {
			Point p = s.pop();
			for (int k = 0; k < x.length; k++) {
				if (p.i + x[k] >= 0 && p.i + x[k] < m && p.j + y[k] >= 0
						&& p.j + y[k] < n && c[p.i + x[k]][p.j + y[k]] == 'O') {
					c[p.i + x[k]][p.j + y[k]] = '$';
					s.push(new Point(p.i + x[k], p.j + y[k]));
				}
			}
		}
	}

}

class Point {
	int i;
	int j;

	public Point(int a, int b) {
		i = a;
		j = b;
	}
}