package com.code.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate permissions in order.
 * 
 * @author dhass
 *
 */
public class Permutations {
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		Permutations p = new Permutations();
		System.out.println(p.permute(a));
	}

	public List<List<Integer>> permute(int[] num) {
		permute(num, 0);
		return res;
	}

	public void permute(int[] num, int index) {
		int l = num.length;
		if (index >= l - 1) {
			List<Integer> li = new ArrayList<Integer>();
			for (int a : num)
				li.add(a);
			res.add(li);
		}
		// System.out.println(Arrays.toString(num));
		else {
			for (int i = index; i < l; i++) {
				swap(num, i, index);
				permute(num, index + 1);
				swap(num, index, i);
			}
		}
	}

	public void swap(int A[], int i, int j) {
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
	}
}
