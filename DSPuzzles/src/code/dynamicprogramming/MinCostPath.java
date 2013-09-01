package code.dynamicprogramming;

public class MinCostPath {
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		MinCostPath m = new MinCostPath();
		System.out.println(m.getMinCostPath(a));
	}

	public int getMinCostPath(int a[][]) {
		int tc[][] = new int[a.length][a.length];
		tc[0][0] = a[0][0];
		for (int i = 1; i < a.length; i++) {
			tc[i][0] = tc[i - 1][0] + a[i][0];
		}

		for (int j = 1; j < a.length; j++) {
			tc[0][j] = tc[0][j - 1] + a[0][j];
		}

		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j < a.length; j++) {
				tc[i][j] = min(tc[i - 1][j], tc[i][j - 1], tc[i - 1][j - 1])
						+ a[i][j];
			}

		}

		return tc[a.length - 1][a.length - 1];
	}

	int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);

	}
}
