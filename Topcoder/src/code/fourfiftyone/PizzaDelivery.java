package code.fourfiftyone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaDelivery {
	int INF = Integer.MAX_VALUE / 2;
	Node[] node;
	Node base;

	public static void main(String[] args) {
		PizzaDelivery p = new PizzaDelivery();
		String terrain[] = { "001000$", "$010X0$", "0010000" };
		System.out.println(p.delieverAll(terrain));
	}

	public int delieverAll(String terrain[]) {
		node = new Node[terrain.length * terrain[0].length()];
		int n = node.length;
		base = new Node(0, 0, 0);
		int count = 0, start = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[i].length(); j++, count++) {
				if (terrain[i].charAt(j) == '$') {
					node[count] = new Node(i, j, INF);
					list.add(count);
				} else if (terrain[i].charAt(j) == 'X') {
					node[count] = new Node(i, j, INF);
					base = node[count];
					start = count;
				} else
					node[count] = new Node(i, j,
							(int) terrain[i].charAt(j) - '0');
			}
		}

		int g[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				g[i][j] = g[j][i] = process(i, j);

		int d[] = new int[n];
		boolean used[] = new boolean[n];
		Arrays.fill(d, INF);
		d[start] = 0;
		int v = -1;

		for (int i = 0; i < n; i++) {
			v = -1;
			for (int j = 0; j < n; j++)
				if (!used[j] && (v == -1 || d[j] < d[v]))
					v = j;
			for (int j = 0; j < n; j++)
				if (d[j] > d[v] + g[v][j])
					d[j] = d[v] + g[v][j];
			used[v] = true;

		}

		int dist[] = new int[list.size()];
		for (int i = 0; i < dist.length; i++)
			dist[i] = d[list.get(i)];
		Arrays.sort(dist);
		int m = dist.length, res = Integer.MAX_VALUE;
		for (int i = 0; i < dist.length; i++)
			if (dist[i] == INF)
				return -1;

		for (int i = 0; i < 1 << m; i++) {
			int one = 0, two = 0, lasto = 0, lastt = 0;
			for (int j = 0; j < m; j++) {
				if ((i & 1 << j) > 0) {
					one += 2 * dist[j];
					lasto = dist[j];
				} else {
					two += 2 * dist[j];
					lastt = dist[j];
				}
			}
			res = Math.min(res, Math.max(one - lasto, two - lastt));
		}
		return res;
	}

	public int process(int x, int y) {
		if (x == y)
			return 0;
		int d = Math.abs(node[x].x - node[y].x)
				+ Math.abs(node[x].y - node[y].y);
		if (d != 1)
			return INF;
		if (node[x].val == INF || node[y].val == INF)
			return 2;
		int diff = Math.abs(node[x].val - node[y].val);
		if (diff == 0)
			return 1;
		else if (diff == 1)
			return 3;
		else
			return INF;
	}

	class Node {
		int x;
		int y;
		int val;

		public Node(int _x, int _y, int _val) {
			x = _x;
			y = _y;
			val = _val;
		}
	}
}
