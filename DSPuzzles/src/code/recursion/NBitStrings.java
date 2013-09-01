package code.recursion;

import java.util.Arrays;

/**
 * Generate all possible bit strings
 * 
 * @author Dhass
 * 
 */
public class NBitStrings {
	byte A[];

	public NBitStrings(int n) {
		A = new byte[n];
	}

	public static void main(String[] args) {
		NBitStrings n = new NBitStrings(5);
		n.generate(n.A.length);
	}

	void generate(int n) {
		if (n < 1) {
			System.out.println(Arrays.toString(A));
			return;
		}
		A[n - 1] = 0;
		generate(n - 1);
		A[n - 1] = 1;
		generate(n - 1);
	}
}
