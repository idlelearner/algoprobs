package code.dynamicprogramming;

/**
 * 0/1 knapsack problem
 * 
 * @author Dhass
 * 
 */
public class KnapSack {

	public static void main(String[] args) {
		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int W = 50;
		KnapSack k = new KnapSack();
		System.out.println(k.knapSack(W, wt, val, val.length));
		System.out.println(k.knapSackRecur(W, wt, val, val.length));
	}

	int knapSackRecur(int W, int wt[], int va[], int n) {
		// Base case
		if (W == 0 || n == 0)
			return 0;
		// Don take the weight greater than the given weight
		if (wt[n - 1] > W)
			return knapSackRecur(W, wt, va, n - 1);
		else
			return Math.max(
					va[n - 1] + knapSackRecur(W - wt[n - 1], wt, va, n - 1),
					knapSackRecur(W, wt, va, n - 1));
	}

	// Returns the maximum value that can be put in a knapsack of capacity W
	int knapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]],
							K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[n][W];
	}
}
