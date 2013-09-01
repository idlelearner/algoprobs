package code;

public class MinNoJumps {
	public static void main(String[] args) {
		MinNoJumps m = new MinNoJumps();
		int a[] = { 1, 0, 0, 0, 0 };
		System.out.println(m.minJumps(a, a.length));
	}

	int minJumps(int arr[], int n) {
		int jumps[] = new int[n]; // jumps[n-1] will hold the result
		int i, j;

		if (n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;

		jumps[0] = 0;

		// Find the minimum number of jumps to reach arr[i]
		// from arr[0], and assign this value to jumps[i]
		for (i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (j = 0; j < i; j++) {
				if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = jumps[j] + 1;
					break;
				}
			}
		}
		return jumps[n - 1];
	}

}
