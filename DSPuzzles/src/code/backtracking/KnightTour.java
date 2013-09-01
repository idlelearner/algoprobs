package code.backtracking;

public class KnightTour {
	public static void main(String[] args) {
		KnightTour kt = new KnightTour();
		kt.KTTour(0, 0);
	}

	public void KTTour(int start, int end) {
		int sol[][] = new int[8][8];
		/*
		 * xMove[] and yMove[] define next move of Knight. xMove[] is for next
		 * value of x coordinate yMove[] is for next value of y coordinate
		 */
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		// Since the Knight is initially at the first block
		sol[start][end] = 0;
		if (solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
			printSol(sol);
		} else {
			System.out.println("Cannot be solved for " + start + " " + end);
		}
	}

	public boolean solveKTUtil(int x, int y, int movei, int sol[][],
			int xMove[], int yMove[]) {
		int k, next_x, next_y;
		if (movei == 64)
			return true;

		/* Try all next moves from the current coordinate x, y */
		for (k = 0; k < 8; k++) {
			next_x = x + xMove[k];
			next_y = y + yMove[k];
			if (isSafe(next_x, next_y, sol)) {
				sol[next_x][next_y] = movei;
				if (solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove))
					return true;
				else
					sol[next_x][next_y] = 0;// backtracking
			}
		}

		return false;
	}

	public void printSol(int sol[][]) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[i].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean isSafe(int x, int y, int sol[][]) {
		if (x >= 0 && x < sol.length && y >= 0 && y < sol.length
				&& sol[x][y] == 0)
			return true;
		return false;
	}
}