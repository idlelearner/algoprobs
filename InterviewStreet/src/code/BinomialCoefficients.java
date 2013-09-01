package code;

import java.util.Scanner;

public class BinomialCoefficients {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N;
		N = in.nextInt();
		BinomialCoefficients b = new BinomialCoefficients();
		int count = 0;
		int val = 0;
		int c = 0, p = 0;
		for (int i = 0; i < N; i++) {
			c = in.nextInt();
			p = in.nextInt();

			for (int k = 1; k <= p; k++) {
				val = b.binomialCoeff(c, k);
				if (val % p == 0)
					count++;
			}
			System.out.println(count);
		}
	}

	// Returns value of Binomial Coefficient C(n, k)
	int binomialCoeff(int n, int k) {
		int res = 1;

		// Since C(n, k) = n (n, n-k)
		if (k > n - k)
			k = n - k;

		// Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
		for (int i = 0; i < k; ++i) {
			res *= (n - i);
			res /= (i + 1);
		}

		return res;
	}
}
