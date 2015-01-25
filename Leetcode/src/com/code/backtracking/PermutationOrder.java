package com.code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationOrder {
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		int num[] = { 1, 2, 3 };
		PermutationOrder p = new PermutationOrder();
		System.out.println(p.permute(num));
	}

	public List<List<Integer>> permute(int[] num) {
		ArrayList<Integer> s = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++)
			s.add(num[i]);
		permutationsInorder(new ArrayList<Integer>(), s);
		return res;
	}

	public void permutationsInorder(ArrayList<Integer> prefix,
			ArrayList<Integer> s) {
		int len = s.size();
		if (len == 0) {
			res.add(prefix);
		}
		for (int i = 0; i < s.size(); i++) {
			ArrayList<Integer> n = new ArrayList<Integer>();
			n.addAll(s.subList(0, i));
			n.addAll(s.subList(i + 1, len));
			prefix.add(s.get(i));
			permutationsInorder(prefix, n);
			prefix.remove(prefix.size() - 1);
		}
	}
}
