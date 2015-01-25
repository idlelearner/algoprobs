package com.code.twoptrs;

/**
 * Remove a given elmt from the array
 * 
 * @author thirunavukarasu
 * 
 */
public class RemoveElmt {
	public int removeElement(int[] A, int elem) {
		int l = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[l] = A[i];
				l++;
			}
		}
		return l;
	}
}
