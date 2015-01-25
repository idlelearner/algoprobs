package com.code.backtracking;

/**
 * 
 * @author dhass
 *
 */
public class PermutationKth {
	int c = 0;
	String res = "";

	public static void main(String[] args) {
		PermutationKth p = new PermutationKth();
		System.out.println(p.getPermutation(8, 27891));
	}

	public String getPermutation(int n, int k) {
		String s = "";
		for (int i = 1; i <= n; i++) {
			s = s + i;
		}
		return getPermutation("", s, k);
	}

	public String getPermutation(String prefix, String s, int k) {
		int l = s.length();
		if (l == 0) {
			c++;
			System.out.println(prefix + " " + c);
			if (k == c)
				return prefix;
		}
		for (int i = 0; i < s.length(); i++) {
			res = getPermutation(prefix + s.charAt(i),
					s.substring(0, i) + s.substring(i + 1, l), k);
			if (!res.equals(""))
				break;
		}
		return res;
	}
}
