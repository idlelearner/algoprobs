package com.code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumDuplicates {
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		CombinationSumDuplicates c = new CombinationSumDuplicates();
		int a[] = { 1, 2 };
		System.out.println(c.combinationSum(a, 3));

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		int t[] = new int[target];
		Arrays.sort(candidates);
		getAllCombinationsSum(candidates, 0, t, target, 0);
		return res;
	}

	public void getAllCombinationsSum(int[] a, int j, int t[], int target, int n) {
		if (target == 0 && n > 0) {
			List<Integer> arr = new ArrayList<Integer>();
			for (int i = 0; i < n; i++)
				arr.add(t[i]);
			res.add(arr);
		} else if (target < 0) {
			return;
		} else {
			for (int k = j; k < a.length; k++) {
				t[n] = a[k];
				getAllCombinationsSum(a, k, t, target - a[k], n + 1);
			}
		}
	}
}
