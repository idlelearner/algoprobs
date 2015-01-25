package com.code.dynamicprogramming;

/**
 * Decode the given digits into all possible alphabet arrangements.
 * 
 * @author dhass
 *
 */
public class DecodeWays {
	public static void main(String[] args) {
		DecodeWays d = new DecodeWays();
		System.out.println(d.numDecodings("25"));
	}

	public int numDecodings(String s) {
		int m[] = new int[s.length() + 1];
		int n = s.length();
		if (n == 0)
			return 0;
		m[n] = 1;
		m[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
		for (int i = n - 2; i >= 0; i--) {
			if (s.charAt(i) == '0')
				continue;
			if (Integer.parseInt(s.substring(i, i + 2)) <= 26)
				m[i] = m[i + 1] + m[i + 2];
			else
				m[i] = m[i + 1];
		}
		return m[0];
	}
}
