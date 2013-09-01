package code;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class EvenTree {
	public static void main(String[] args) {
		// helpers for input/output
		Scanner in = new Scanner(System.in);

		int N, K;
		N = in.nextInt();
		K = in.nextInt();
		int x[] = new int[K];
		int y[] = new int[K];
		int adj[][] = new int[N + 1][N + 1];
		EvenTree e = new EvenTree();
		for (int i = 0; i < K; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			e.addEdge(adj, x[i], y[i]);
		}

		int c1, c2, evenForestCount = 0;
		for (int i = 0; i < K; i++) {
			e.removeEdge(adj, x[i], y[i]);

			c1 = e.dfs(adj, x[i]);
			c2 = e.dfs(adj, y[i]);
			if (c1 % 2 == 0 && c2 % 2 == 0)
				evenForestCount++;
			e.addEdge(adj, x[i], y[i]);
		}

		System.out.println(evenForestCount);
	}

	public int dfs(int adj[][], int s) {
		boolean visited[] = new boolean[adj.length + 1];
		Arrays.fill(visited, false);
		Stack<Integer> stack = new Stack<Integer>();
		int count = 0;
		stack.push(s);
		visited[s] = true;
		count++;
		while (!stack.isEmpty()) {
			int v = stack.peek();
			int adjNode = getUnVisitedAdjNode(adj, visited, v);
			if (adjNode == -1)
				stack.pop();
			else {
				stack.push(adjNode);
				visited[adjNode] = true;
				count++;
			}
		}
		return count;
	}

	public int getUnVisitedAdjNode(int adj[][], boolean visited[], int i) {
		for (int j = 1; j < adj.length; j++)
			if (adj[i][j] != 0 && !visited[j])
				return j;
		return -1;
	}

	public void addEdge(int adj[][], int x, int y) {
		adj[x][y] = 1;
		adj[y][x] = 1;
	}

	public void removeEdge(int adj[][], int x, int y) {
		adj[x][y] = 0;
		adj[y][x] = 0;
	}
}
