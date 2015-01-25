package com.code.backtracking;

import java.util.HashMap;
/**
 * Find number of ways to match the given character
 * @author thirunavukarasu
 *
 */
public class DecodeWays {
	int count = 0;
	HashMap<Integer, Character> map = new HashMap<Integer, Character>();

	public DecodeWays() {
		char c = 'a';
		for (int i = 0; i < 26; i++)
			map.put(i + 1, (char) (c + i));
	}

	public static void main(String[] args) {
		String s = "4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948";
		DecodeWays l = new DecodeWays();
		l.numDecodings(s);
		System.out.println(l.count);
	}

	public int numDecodings(String s) {
		getCombinations(s, s.length());
		return count;
	}

	public void getCombinations(String s, int n) {
		if (s.length() == 0) {
			count++;
		} else {
			getCombinations(s.substring(1, s.length()), n - 1);
			if (s.length() > 1) {
				Integer k = Integer.parseInt("" + s.charAt(0) + s.charAt(1));
				if (map.containsKey(k)) {
					getCombinations(s.substring(2, s.length()), n - 2);
				}
			}
		}
	}
}
