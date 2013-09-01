package code.backtracking;

import java.util.Arrays;

/**
 * Placing N-queen problem
 * 
 * @author Dhass
 * 
 */
public class NQueenProblem {
	int columnForRow[];
	int count;

	public NQueenProblem(int n) {
		count = n;
		columnForRow = new int[n];
	}

	// check for row wise and column meeting and diagonal meeting
	public boolean check(int row) {
		for (int i = 0; i < row; i++) {
			int diff = Math.abs(columnForRow[i] - columnForRow[row]);
			if (diff == 0 || diff == row - i)
				return false;
		}
		return true;
	}

	// Place the queens in rows by backtracking
	void PlaceQueen(int row) {
		if (row == count) {
			printBoard();
			return;
		}
		for (int i = 0; i < count; i++) {
			columnForRow[row] = i;
			if (check(row)) {
				PlaceQueen(row + 1);
			}
		}
	}

	public void printBoard() {
		System.out.println(Arrays.toString(columnForRow));
	}

	public static void main(String[] args) {
		NQueenProblem q = new NQueenProblem(4);
		q.PlaceQueen(0);
	}
}
