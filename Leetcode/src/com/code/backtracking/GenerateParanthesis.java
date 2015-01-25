package com.code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	List<String> res = new ArrayList<String>();

	public static void main(String[] args) {
		GenerateParanthesis g = new GenerateParanthesis();
		System.out.println(g.generateParenthesis(3));
	}

	public List<String> generateParenthesis(int n) {
		n = 2*n;
		genParanthesis(n, 0, 0, new char[n], 0);
		return res;
	}

	public void genParanthesis(int n, int open, int close, char c[], int i) {
		if (i == n)
			res.add(new String(c));
		if (open < n / 2) {
			c[i] = '(';
			genParanthesis(n, open + 1, close, c, i + 1);
		}
		if (close < n / 2 && close < open) {
			c[i] = ')';
			genParanthesis(n, open, close + 1, c, i + 1);
		}

	}
}
