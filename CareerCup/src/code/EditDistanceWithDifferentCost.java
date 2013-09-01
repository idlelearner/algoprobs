package code;

public class EditDistanceWithDifferentCost {
	public static void main(String[] args) {
		EditDistanceWithDifferentCost e = new EditDistanceWithDifferentCost();
		String s1 = "LATER";
		String s2 = "LATE";
		System.out.println(e.minEdits(s1.toCharArray(), s2.toCharArray()));
	}

	public final int I = 8;
	public final int D = 6;
	public final int R = 8;
	public int minEdits(char s1[], char s2[]) {
		int m = s1.length, n = s2.length;
		int d[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0)
					d[i][j] = j * I;
				else if (j == 0)
					d[i][j] = i * D;
				else {
					if (j < i)
						d[i][j] = minimum(d[i - 1][j - 1]
								+ ((s1[i - 1] == s2[j - 1]) ? 0 : R),
								d[i - 1][j] + R, d[i][j - 1] + I);
					else
						d[i][j] = minimum(d[i - 1][j - 1]
								+ ((s1[i - 1] == s2[j - 1]) ? 0 : R),
								d[i - 1][j] + R, d[i][j - 1] + D);
				}

			}
		}
		return d[m][n];
	}

	public int minimum(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

}
