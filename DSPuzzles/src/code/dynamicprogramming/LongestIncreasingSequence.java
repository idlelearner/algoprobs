package code.dynamicprogramming;

/**
 * Longest increasing subsequence and maximum increasing sum subsequence.
 * 
 * @author Dhass
 * 
 */
public class LongestIncreasingSequence {
	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 2, 6, 9, 1 };
		LongestIncreasingSequence l = new LongestIncreasingSequence();
		System.out.println(l.lis(a, a.length));
		System.out.println(l.maxSumIS(a, a.length));
	}

	/*
	 * lis() returns the length of the longest increasing subsequence in arr[]
	 * of size n
	 */
	int lis(int arr[], int n) {
		int lis[] = new int[n];
		int i, j, max = 0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++)
			lis[i] = 1;

		/* Compute optimized LIS values in bottom up manner */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;

		/* Pick maximum of all LIS values */
		for (i = 0; i < n; i++)
			if (max < lis[i])
				max = lis[i];

		return max;
	}

	/*
	 * maximum sum subsequence problem - maxSumIS() returns the maximum sum of
	 * increasing subsequence in arr[] of size n
	 */
	int maxSumIS(int arr[], int n) {
		int msis[] = new int[n];
		int i, j, max = 0;

		/* Initialize msis values for all indexes */
		for (i = 0; i < n; i++)
			msis[i] = arr[i];

		/* Compute maximum sum values in bottom up manner */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
					msis[i] = msis[j] + arr[i];

		/* Pick maximum of all msis values */
		for (i = 0; i < n; i++)
			if (max < msis[i])
				max = msis[i];

		return max;
	}
}
