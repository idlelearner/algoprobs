package com.code.common;

import java.util.ArrayList;

public class RemoveElement {
	public static void main(String[] args) {
		RemoveElement r = new RemoveElement();
		int A[] = { 2 };
		System.out.println(r.removeElement(A, 3));
	}

	public int removeElement(int[] A, int elem) {
		if (A.length == 0)
			return 0;
		int l = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[l] = A[i];
				l++;
			}
		}
		return ++l;
	}
}
