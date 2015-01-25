package com.code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GreyCode {
	List<Integer> res = new ArrayList<Integer>();

	public static void main(String[] args) {
		GreyCode g = new GreyCode();
		System.out.println(g.grayCode(3));
	}

	public List<Integer> grayCode(int n) {
		if (n == 0)
			return res;
		char c[] = new char[n];
		for (int i = 0; i < n; i++)
			c[i] = '0';
		res.add(0);
		greyCode(c, n);
		return res;
	}

	public void greyCode(char c[], int n) {
		for (int i = n - 1; i >= 0; i--) {
			c[i] = '1';
			res.add(Integer.parseInt(new String(c), 2));
			greyCode(c, n - 1);
			c[i] = '0';
		}
	}
}
