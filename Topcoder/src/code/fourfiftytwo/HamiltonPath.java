package code.fourfiftytwo;

import java.util.ArrayList;

public class HamiltonPath {
	char G[][];
	char vis[][];
	int n;
	boolean visited[];
	int count = 0;

	public static void main(String[] args) {
		HamiltonPath h = new HamiltonPath();
		// String roads[] = { "NYN", "YNN", "NNN" };
		String roads[] = { "NNNNNY", "NNNNYN", "NNNNYN", "NNNNNN", "NYYNNN",
				"YNNNNN" };
		System.out.println(h.countPaths(roads));
	}

	public int countPaths(String[] roads) {
		int vertices[] = new int[roads.length];
		n = roads.length;
		int v = 0;
		G = new char[n][n];
		vis = new char[n][n];
		for (int i = 0; i < n; i++)
			vertices[i] = i;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				vis[i][j] = G[i][j] = roads[i].charAt(j);

		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			count = 0;
			countPaths(i, i, 0);
			v += count % 1000000007;
		}
		return v;
	}

	public void countPaths(int i, int k, int pathlen) {
		if (pathlen == n - 1 && visitedGivenRoads(vis)) {
			count++;
			return;
		}
		if (pathlen >= n)
			return;
		ArrayList<Integer> adj = getAdj(k);
		for (int a : adj) {
			if (!visited[a]) {
				visited[a] = true;
				pathlen++;
				if (G[k][a] == 'Y')
					vis[a][k] = vis[k][a] = 'N';

				countPaths(i, a, pathlen);
				pathlen--;
				visited[a] = false;
				if (G[k][a] == 'Y')
					vis[a][k] = vis[k][a] = 'Y';
			}
		}
	}

	public ArrayList<Integer> getAdj(int j) {
		ArrayList<Integer> adj = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			if (i != j)
				adj.add(i);
		return adj;
	}

	public boolean visitedGivenRoads(char vis[][]) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (vis[i][j] == 'Y')
					return false;
		return true;
	}
}