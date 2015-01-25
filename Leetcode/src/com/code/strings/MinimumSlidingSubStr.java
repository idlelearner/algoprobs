package com.code.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the minimum length string in the given S, T
 * 
 * @author dhass
 *
 */
public class MinimumSlidingSubStr {

	public static void main(String[] args) {
		MinimumSlidingSubStr m = new MinimumSlidingSubStr();
		System.out.println(m.minWindow("bba", "ab"));
	}

	public String minWindow(String S, String T) {
		// To hold the characters traversed
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		// Reference for count of strings.
		Map<Character, Integer> tMap = new HashMap<Character, Integer>();
		if (S.equals("") || T.equals(""))
			return "";
		for (int k = 0; k < T.length(); k++) {
			Character tc = T.charAt(k);
			map.put(tc, 0);
			if (tMap.containsKey(tc))
				tMap.put(tc, tMap.get(tc) + 1);
			else
				tMap.put(tc, 1);
		}

		int i = 0, n = 0;
		String min = new String(S);
		int tl = T.length();
		for (int k = 0; k < S.length(); k++) {
			Character jc = S.charAt(k);
			if (!map.containsKey(jc))
				continue;
			if (map.get(jc) < tMap.get(jc))
				n++;
			map.put(jc, map.get(jc) + 1);

			// Try moving the start ptr forward.
			while (i < S.length()
					&& (!map.containsKey(S.charAt(i)) || map.get(S.charAt(i)) > tMap
							.get(S.charAt(i)))) {
				if (map.containsKey(S.charAt(i))) {
					Character ic = S.charAt(i);
					map.put(ic, map.get(ic) - 1);
				}
				i++;
			}

			if (n >= tl) {
				if (min.length() > ((k - i) + 1))
					min = S.substring(i, k + 1);
			}
		}

		return n >= tl ? min : "";
	}
}
