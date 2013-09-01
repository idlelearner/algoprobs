package code.dynamicprogramming;

public class EditDistanceAlgo {
	int SENTINEL = -1;
	int EDIT_COST = 1;

	public static void main(String[] args) {
		EditDistanceAlgo e = new EditDistanceAlgo();
		String a = "SUNDAY";
		String b = "SATURDAY";
		System.out.println(e.EditDistanceDP(a.toCharArray(), b.toCharArray()));
	}

	int EditDistanceDP(char st1[], char st2[]) {
		int[][] s = new int[st1.length + 1][st2.length + 1];
		for (int i = 0; i <= st1.length; i++) {
			for (int j = 0; j <= st2.length; j++) {
				if (i == 0)
					s[i][j] = j;
				else if (j == 0)
					s[i][j] = i;
				else
					s[i][j] = minimum(s[i - 1][j - 1]
							+ (st1[i - 1] == st2[j - 1] ? 0 : 1),
							s[i - 1][j] + 1, s[i][j - 1] + 1);
			}
		}
		return s[st1.length][st2.length];
	}

	public int minimum(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
}
