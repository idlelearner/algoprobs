package com.code.backtracking;

/**
 * Find the given word in the matrix Time limit exceeded.
 * 
 * @author thirunavukarasu
 * 
 */
public class FindWord {

	public static void main(String[] args) {
		char m[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		FindWord f = new FindWord();
		System.out.println(f.exist(m, "ABCCED"));
		System.out.println(f.exist(m, "SEE"));
		System.out.println(f.exist(m, "ABCB"));
	}

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		boolean visited[][] = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (exist(board, word, i, j, visited, 0)) {
					return true;
				}
			}
			// System.out.println("");
		}
		return false;
	}

	public boolean exist(char board[][], String word, int x, int y,
			boolean visited[][], int ci) {
		if (!isSafe(x, y, board, visited))
			return false;
		if (ci == word.length())
			return true;
		visited[x][y] = true;
		boolean found = false;
		if (board[x][y] == word.charAt(ci)) {
			// System.out.print(x + " " + y + " " + board[x][y] + " ");
			ci++;
			found = exist(board, word, x + 1, y, visited, ci);
			if (!found)
				found = exist(board, word, x, y + 1, visited, ci);
			if (!found)
				found = exist(board, word, x - 1, y, visited, ci);
			if (!found)
				found = exist(board, word, x, y - 1, visited, ci);
		}
		ci--;
		visited[x][y] = false;
		return found;
	}

	public boolean isSafe(int x, int y, char[][] board, boolean visited[][]) {
		int m = board.length;
		int n = board[0].length;
		return (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]);
	}
}
