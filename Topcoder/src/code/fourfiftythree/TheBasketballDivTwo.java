package code.fourfiftythree;

public class TheBasketballDivTwo {
	char[][] p;
	int wins[];
	int n;

	public static void main(String[] args) {
		TheBasketballDivTwo b = new TheBasketballDivTwo();
		String table[] = {"XW?", "LX?", "??X"};
		System.out.println(b.find(table));
	}
	
	public int find(String[] table) {
		n = table.length;
		wins = new int[n];
		p = new char[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				p[i][j] = table[i].charAt(j);
				if (p[i][j] == 'W')
					wins[i]++;
				if (p[i][j] == 'L')
					wins[j]++;
			}
		int count = getMinimumWins();
		return count;
	}

	public int getMinimumWins() {
		int w = 0;
		if (isTournamentOver())
			return getMax(wins);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int w1 = 0, w2 = 0;
				if (p[i][j] == '?') {
					p[i][j] = 'W';
					wins[i]++;
					w1 = getMinimumWins();
					wins[i]--;
					p[i][j] = 'L';
					wins[j]++;
					w2 = getMinimumWins();
					wins[j]--;
					p[i][j] = '?';
					w = w1 < w2 ? w1 : w2;
					return w;
				}
			}
		}
		return w;
	}

	public boolean isTournamentOver() {
		for (int i = 0; i < p.length; i++)
			for (int j = 0; j < p.length; j++)
				if (p[i][j] == '?')
					return false;
		return true;
	}

	public int getMax(int a[]) {
		int m = 0;
		for (int i = 0; i < a.length; i++)
			if (m < a[i])
				m = a[i];
		return m;
	}
}