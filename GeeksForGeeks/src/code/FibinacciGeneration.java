package code;

public class FibinacciGeneration {

	/* Driver program to test above function */
	public static void main(String[] args) {
		long n = 500000;
		FibinacciGeneration f = new FibinacciGeneration();
		System.out.println(f.fib(n));
	}

	/* function that returns nth Fibonacci number */
	long fib(long n) {
		long F[][] = { { 1, 1 }, { 1, 0 } };
		if (n == 0)
			return 0;
		power(F, n - 1);
		return F[0][0];
	}

	/* Optimized version of power() in method 4 */
	void power(long F[][], long n) {
		if (n == 0 || n == 1)
			return;
		long M[][] = { { 1, 1 }, { 1, 0 } };

		power(F, n / 2);
		multiply(F, F);

		if (n % 2 != 0)
			multiply(F, M);
	}

	void multiply(long F[][], long M[][]) {
		long x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
		long y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
		long z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
		long w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

		F[0][0] = x;
		F[0][1] = y;
		F[1][0] = z;
		F[1][1] = w;
	}

}
