package code.dynamicprogramming;

public class MatrixChainMultiplication {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		MatrixChainMultiplication m = new MatrixChainMultiplication();
		System.out.println(m.MatrixChainOrder(a, a.length));
	}

	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	int MatrixChainOrder(int p[], int n) {

		/*
		 * For simplicity of the program, one extra row and one extra column are
		 * allocated in m[][]. 0th row and 0th column of m[][] are not used
		 */
		int m[][] = new int[n+1][n+1];

		int i, j, k, L, q;

		/*
		 * m[i,j] = Minimum number of scalar multiplications needed to compute
		 * the matrix A[i]A[i+1]...A[j] = A[i..j] where dimention of A[i] is
		 * p[i-1] x p[i]
		 */

		// cost is zero when multiplying one matrix.
		for (i = 1; i < n; i++)
			m[i][i] = 0;

		// L is chain length.
		for (L = 2; L < n; L++) {
			for (i = 1; i <= n - L + 1; i++) {
				j = i + L - 1;
				m[i][j] = Integer.MAX_VALUE;
				for (k = i; k <= j - 1; k++) {
					// q = cost/scalar multiplications
					q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (q < m[i][j])
						m[i][j] = q;
				}
			}
		}

		return m[1][n - 1];
	}
}
