package com.code.bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Compute all the subsets of the given set.
 * 
 * @author dhass
 *
 */
public class Subset {
	public List<List<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		int l = S.length;
		int n = (int) Math.pow(2, l);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> subList = new ArrayList<Integer>();
			for (int j = 0; j < l; j++) {
				int v = i & 1 << j;
				if (v != 0)
					subList.add(S[j]);
			}
			list.add(subList);
		}
		return list;
	}
}
