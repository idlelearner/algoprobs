package code;

import java.util.Arrays;
import java.util.Scanner;

public class Candies {
	public static void main(String[] args) {
		// helpers for input/output
		Scanner in = new Scanner(System.in);

		int N;
		N = in.nextInt();

		int rating[] = new int[N];
		for (int i = 0; i < N; i++) {
			rating[i] = in.nextInt();
		}

		Candies c = new Candies();
		System.out.println(c.getMinCostOfCandies(rating));
	}

	long getMinCostOfCandies(int a[]) {
		long minCost = 0;
		int in[] = { -1, 1 };
		int c[] = new int[a.length];
		Arrays.fill(c, 1);
		while (true) {
			boolean cont = true;
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < in.length; j++) {
					int next = i + in[j];
					if (next >= 0 && next < a.length) {
						if (a[next] > a[i] && c[next] <= c[i]) {
							c[next] = c[i] + 1;
							cont = false;
						}
					}
				}
			}
			if (cont)
				break;
		}
		for (int i = 0; i < c.length; i++)
			minCost += c[i];
		return minCost;
	}
}
