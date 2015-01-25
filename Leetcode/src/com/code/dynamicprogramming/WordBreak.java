package com.code.dynamicprogramming;

import java.util.Set;

/**
 * Check if the given string can be split into given dictionary words
 * 
 * @author dhass
 *
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		boolean t[] = new boolean[s.length() + 1];
		t[0] = true;
		for (int i = 0; i < s.length(); i++) {
			if (t[i]) {
				for (String d : dict) {
					int l = d.length();
					if (i + l <= s.length()) {
						if (s.substring(i, i + l).equals(d))
							t[i + l] = true;
					}
				}
			}
		}
		return t[s.length()];
	}
}
