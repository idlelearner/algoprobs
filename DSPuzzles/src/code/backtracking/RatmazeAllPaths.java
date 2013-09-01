package code.backtracking;

public class RatmazeAllPaths {
	int N;

	public RatmazeAllPaths(int n) {
		N = n;
	}

	public static void main(String[] args) {
		RatmazeAllPaths r = new RatmazeAllPaths(4);
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 1, 0 },
				{ 1, 1, 1, 1 } };
		r.solveRatMaze(maze);
	}

	public void solveRatMaze(int maze[][]) {
		int sol[][] = new int[N][N];
		solveMazeUtil(maze, 0, 0, sol);
	}

	public void solveMazeUtil(int maze[][], int x, int y, int sol[][]) {
		if (x == N - 1 && y == N - 1) {
			sol[x][y] = 1;
			printMaze(sol);
		}
		if (isSafe(maze, x, y)) {
			sol[x][y] = 1;
			solveMazeUtil(maze, x + 1, y, sol);
			solveMazeUtil(maze, x, y + 1, sol);
			sol[x][y] = 0;
		}
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
		System.out.println(" ");
	}
}
