package com.code.twoptrs;

/**
 * Given a array with 0,1,2 sort it
 * 
 * @author thirunavukarasu
 * 
 */
public class DutchFlag {
	public void sortColors(int[] A) {
		int r = 0, b = A.length - 1;
		for (int i = 0; i < A.length; i++) {
			// Move all 2's to the end.
			while (A[i] == 2 && i <= b) {
				int t = A[b];
				A[b] = A[i];
				A[i] = t;
				b--;
			}
			// Move all 1's to the first.
			while (A[i] == 0 && i >= r) {
				int t = A[r];
				A[r] = A[i];
				A[i] = t;
				r++;
			}
		}
	}
}
