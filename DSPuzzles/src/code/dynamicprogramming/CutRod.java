package code.dynamicprogramming;

public class CutRod {

	public static void main(String[] args) {
		int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		CutRod c = new CutRod();
		System.out.println(c.cutRod(arr, arr.length));
	}

	/*
	 * Returns the best obtainable price for a rod of length n and price[] as
	 * prices of different pieces
	 */
	int cutRod(int price[], int n) {
		int val[] = new int[n + 1];
		val[0] = 0;
		int i, j;

		// Build the table val[] in bottom up manner and return the last entry
		// from the table
		for (i = 1; i <= n; i++) {
			int max_val = Integer.MIN_VALUE;
			for (j = 0; j < i; j++)
				max_val = Math.max(max_val, price[j] + val[i - j - 1]);
			val[i] = max_val;
		}

		return val[n];
	}
}
