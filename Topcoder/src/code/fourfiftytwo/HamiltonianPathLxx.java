package code.fourfiftytwo;

public class HamiltonianPathLxx {

	boolean vis[];
	int d[];
	char road[][];
	int n;

	public static void main(String[] args) {
		HamiltonianPathLxx h = new HamiltonianPathLxx();
		String roads[] = { "NYN", "YNN", "NNN" };
		// String roads[] = { "NNNNNY", "NNNNYN", "NNNNYN", "NNNNNN",
		// "NYYNNN","YNNNNN" };
		System.out.println(h.countPaths(roads));
	}

	void dfs(int now) {
		vis[now] = true;
		for (int i = 0; i < n; i++)
			if ((road[now][i] == 'Y') && (!vis[i]))
				dfs(i);
	}

	int countPaths(String roads[]) {
		n = roads.length;
		road = new char[n][n];
		d = new int[n];
		vis = new boolean[n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				road[i][j] = roads[i].charAt(j);

		for (int i = 0; i < n; i++) {
			int s = 0;
			for (int j = 0; j < n; j++)
				if (road[i][j] == 'Y')
					s++;
			if (s > 2)
				return 0;
			d[i] = s;
		}
		
		int tot1 = 0, tot2 = 0;
		for (int i = 0; i < n; i++)
			if ((!vis[i]) && (d[i] < 2)) {
				dfs(i);
				if (d[i] == 0)
					tot1++;
				else
					tot2++;
		}
		
		for (int i = 0; i < n; i++)
			if (!vis[i])
				return 0;
		long ans = 1;
		for (long i = 0; i < tot1 + tot2; i++)
			ans = (ans * (i + 1)) % 1000000007;
		for (int i = 0; i < tot2; i++)
			ans = (ans * 2) % 1000000007;
		return (int) ans;
	}
}
