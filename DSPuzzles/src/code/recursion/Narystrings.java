package code.recursion;

import java.util.Arrays;

/**
 * Generate all possible combinations for size n and k different values
 * 
 * @author Dhass
 * 
 */
public class Narystrings {
	int A[];
	int count;

	public Narystrings(int n) {
		A = new int[n];
	}

	public static void main(String[] args) {
		Narystrings n = new Narystrings(5);
		n.kString(n.A.length, 7);
		System.out.println("Number of combinations : " + n.count);
	}

	void kString(int n, int k) {
		if (n < 1) {
			System.out.println(Arrays.toString(A));
			count++;
			return;
		}
		for (int i = 0; i < k; i++) {
			A[n - 1] = i;
			kString(n - 1, k);
		}
	}

}
