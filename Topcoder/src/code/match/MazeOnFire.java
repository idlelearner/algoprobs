package code.match;

class MazeOnFire {

	public static void main(String[] args) {
		MazeOnFire m = new MazeOnFire();
		// String s[] = { "....#.", "$##.#.", ".#..#F", ".F#.#.", "..#..." };
		String s[] = { "F..", ".$.", "..." };
		System.out.println(m.maximumTurns(s));

	}

	public int maximumTurns(String[] maze) {
		int m = maze.length, n = maze[0].length();
		char curPos[][];
		char newPos[][] = new char[m][n];
		char tempPos[][] = new char[m][n];
		curPos = convert(maze);
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				newPos[i][j] = curPos[i][j];

		int maxVal = 0;
		do {
			maxVal++;
			nextStep(curPos, newPos);
			if (getCount(newPos) == 0)
				return maxVal;
			tempPos = curPos;
			curPos = newPos;
			newPos = tempPos;
		} while (!sameGrid(curPos, newPos));

		return -1;
	}

	public void nextStep(char curPos[][], char newPos[][]) {
		int m = curPos.length, n = curPos[0].length;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				newPos[i][j] = curPos[i][j];

		int dX[] = { -1, 0, 1, 0 };
		int dY[] = { 0, 1, 0, -1 };

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 4; k++) {
					int nx = i + dX[k];
					int ny = j + dY[k];
					if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
						if (curPos[i][j] == '$' && newPos[nx][ny] == '.')
							newPos[nx][ny] = '$';
						if (curPos[i][j] == 'F' && curPos[nx][ny] != '#')
							newPos[nx][ny] = 'F';
					}
				}
			}
		}
	}

	public int getCount(char c[][]) {
		int count = 0;
		for (int i = 0; i < c.length; i++)
			for (int j = 0; j < c[0].length; j++)
				if (c[i][j] == '$')
					count += 1;
		return count;
	}

	public boolean sameGrid(char cur[][], char nex[][]) {
		int m = cur.length, n = cur[0].length;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (cur[i][j] != nex[i][j])
					return false;
		return true;
	}

	public char[][] convert(String[] maze) {
		char c[][] = new char[maze.length][maze[0].length()];
		for (int i = 0; i < maze.length; i++)
			for (int j = 0; j < maze[0].length(); j++)
				c[i][j] = maze[i].charAt(j);
		return c;
	}
}