package code.backtracking;

public class SubsetOfSumK {

	public static void main(String[] args) {
		SubsetOfSumK s = new SubsetOfSumK();
		int weights[] = { 10, 7, 5, 18, 12, 20, 16 };
		s.generateSubsets(weights, weights.length, 34);
	}

	// Wrapper to print subsets that sum to target_sum
	public void printSubset(int a[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println("");
	}

	// inputs
	// s - set vector
	// t - tuplet vector
	// s_size - set size
	// t_size - tuplet size so far
	// sum - sum so far
	// ite - nodes count
	// target_sum - sum to be found
	void subset_sum(int s[], int t[], int s_size, int t_size, int sum, int ite,
			int target_sum) {
		if (target_sum == sum) {
			// We found subset
			printSubset(t, t_size);
			// Exclude previously added item and consider next candidate
			if(s_size == ite)
				return;
			subset_sum(s, t, s_size, t_size - 1, sum - s[ite], ite + 1,
					target_sum);
			return;
		} else {
			// generate nodes along the breadth
			for (int i = ite; i < s_size; i++) {
				t[t_size] = s[i];
				// consider next level node (along depth)
				subset_sum(s, t, s_size, t_size + 1, sum + s[i], i + 1,
						target_sum);
			}
		}
	}

	
	// input is weights vector and target_sum
	void generateSubsets(int s[], int size, int target_sum) {
		int tuplet_vector[] = new int[size];

		subset_sum(s, tuplet_vector, size, 0, 0, 0, target_sum);

	}

}
