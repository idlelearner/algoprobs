package code.backtracking;

public class RatMazeProblem {
	int N;

	public RatMazeProblem(int n) {
		N = n;
	}

	public static void main(String[] args) {
		RatMazeProblem r = new RatMazeProblem(4);
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 },
				{ 1, 1, 1, 1 } };
		r.solveRatMaze(maze);
	}

	public void solveRatMaze(int maze[][]) {
		int sol[][] = new int[N][N];
		if (solveMazeUtil(maze, 0, 0, sol))
			printMaze(sol);
		else
			System.out.println("maze cannot be solved");
	}

	public boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {
		if (x == N - 1 && y == N - 1) {
			sol[x][y] = 1;
			return true;
		}
		if (isSafe(maze, x, y)) {
			sol[x][y] = 1;
			if (solveMazeUtil(maze, x + 1, y, sol))
				return true;
			if (solveMazeUtil(maze, x, y + 1, sol))
				return true;
			sol[x][y] = 0;
			return false;
		}
		return false;
	}

	public boolean isSafe(int maze[][], int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1)
			return true;
		return false;
	}

	public void printMaze(int sol[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
