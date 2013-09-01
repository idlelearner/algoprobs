package code.dynamicprogramming;

/**
 * GeeksforGeeks soln - Partition the set into subsets with sum of subset = sum/2
 * IMPLEMENT PARTITIONING INTO SUBSETS WITH MIN DIFF
 * @author Dhass
 * 
 */
public class Partition {
	public static void main(String[] args) {

		Partition p = new Partition();
		int a[] = { 1, 5, 11, 7 };
		System.out.println(p.findPartiion(a, a.length));
	}

	// Returns true if arr[] can be partitioned in two subsets of
	// equal sum, otherwise false
	boolean findPartiion(int arr[], int n) {
		int sum = 0;
		int i, j;

		// Calculate sum of all elements
		for (i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;

		boolean part[][] = new boolean[sum / 2 + 1][n + 1];

		// initialize top row as true
		for (i = 0; i <= n; i++)
			part[0][i] = true;

		// initialize leftmost column, except part[0][0], as 0
		for (i = 1; i <= sum / 2; i++)
			part[i][0] = false;

		// Fill the partition table in botton up manner
		for (i = 1; i <= sum / 2; i++) {
			for (j = 1; j <= n; j++) {
				part[i][j] = part[i][j - 1];
				if (i >= arr[j - 1])
					part[i][j] = part[i][j] || part[i - arr[j - 1]][j - 1];
			}
		}

		// uncomment this part to print table
		for (i = 0; i <= sum / 2; i++) {
			for (j = 0; j <= n; j++)
				System.out.print(part[i][j] + " ");
			System.out.println("");
		}

		return part[sum / 2][n];
	}
}
