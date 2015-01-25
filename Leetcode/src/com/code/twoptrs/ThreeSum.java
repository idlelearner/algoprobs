package com.code.twoptrs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		ThreeSum t = new ThreeSum();
		int a[] = { -1, 0, 1, 2, -1, -4 };
		System.out.println(t.threeSum(a));
	}

	public List<List<Integer>> threeSum(int[] num) {
		if (num.length < 3)
			return res;
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			int l = i + 1, r = num.length - 1;
			while (l < r) {
				if (num[i] + num[l] + num[r] == 0) {
					List<Integer> triplet = new ArrayList<Integer>();
					triplet.add(num[i]);
					triplet.add(num[l]);
					triplet.add(num[r]);
					res.add(triplet);
					l++;
					r--;
				} else if (num[l] + num[r] < -1 * num[i])
					l++;
				else
					r--;
			}
		}

		Set<List<Integer>> set = new HashSet<List<Integer>>(res);
		List<List<Integer>> newres = new ArrayList<List<Integer>>();
		for (List<Integer> v : set)
			newres.add(v);
		return newres;
	}
}
