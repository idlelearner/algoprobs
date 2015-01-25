package com.code.backtracking;

/**
 * Regular expression matching - Time limit exceeded.
 * 
 * @author dhass
 *
 */
public class RegExpMatching {
	public static void main(String[] args) {
		RegExpMatching r = new RegExpMatching();
		System.out.println(r.isMatch("ba", "a*"));
	}

	public boolean isMatch(String s, String p) {

		if (p.length() == 0)
			return s.length() == 0;

		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1 || p.charAt(0) != '.'
					|| p.charAt(0) != s.charAt(0))
				return false;
			return isMatch(s.substring(0), p.substring(0));
		} else {
			int l = s.length();
			int i = -1;
			while (i < l
					&& (i < 0 || p.charAt(0) == '.' || s.charAt(i) == p
							.charAt(0))) {
				if (isMatch(s.substring(i + 1), p.substring(2)))
					return true;
				i++;
			}
		}

		return false;
	}
}
