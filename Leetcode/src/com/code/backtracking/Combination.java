package com.code.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Print the Combination of n numbers of K length C(n,k)
 * @author thirunavukarasu
 *
 */
public class Combination {
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		Combination c = new Combination();
		System.out.println(c.combine(4, 2));
	}

	public List<List<Integer>> combine(int n, int k) {
		int num[] = new int[k];
		combine(n, k, 0, num);
		return res;
	}

	public void combine(int n, int k, int len, int num[]) {
		if (len == k) {
			List<Integer> l = new ArrayList<Integer>();
			for (int j = 0; j < k; j++) {
				l.add(num[j]);
			}
			res.add(l);
		} else {
			int i = len == 0 ? 1 : num[len - 1] + 1;
			len++;
			while (i <= n) {
				num[len - 1] = i;
				combine(n, k, len, num);
				i++;
			}
		}
	}
}
