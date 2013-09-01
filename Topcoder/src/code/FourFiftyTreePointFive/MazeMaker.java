package code.FourFiftyTreePointFive;

public class MazeMaker {
	int m, n;

	public static void main(String[] args) {
		MazeMaker o = new MazeMaker();
		String p[] = { "...", "...", "..." };
		
		int x[] = {1,0,-1,0};
		int y[] = {0,1,0,-1};
		System.out.println(o.longestPath(p, 0, 1, x, y));
	}

	public int longestPath(String[] maze, int startRow, int startCol,
			int[] moveRow, int[] moveCol) {
		m = maze.length;
		n = maze[0].length();
		char a[][] = new char[m][n];
		char b[][] = new char[m][n];
		char t[][] = new char[m][n];
		int min = -1;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = b[i][j] = maze[i].charAt(j);

		a[startRow][startCol]='T';
		b[startRow][startCol]='T';
		
		do {
			min++;
			nextJump(a, b, moveRow, moveCol);
			t = a;
			a = b;
			b = t;
		} while (!same(a, b));

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (a[i][j] == '.')
					return -1;
		return min;
	}

	public void nextJump(char a[][], char b[][], int x[], int y[]) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 'T') {
					for (int k = 0; k < x.length; k++) {
						int nx = i + x[k];
						int ny = j + y[k];
						if (nx >= 0 && nx < m && ny >= 0 && ny < n && a[nx][ny]!='X')
							b[nx][ny] = 'T';
					}
				}
			}
		}
	}

	public boolean same(char a[][], char b[][]) {
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (a[i][j] != b[i][j])
					return false;
		return true;
	}

}