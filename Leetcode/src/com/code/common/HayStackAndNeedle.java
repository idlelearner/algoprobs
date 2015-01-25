package com.code.common;
public class HayStackAndNeedle {
	/**
	 * Find the given string in search string. Strstr() fn.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HayStackAndNeedle h = new HayStackAndNeedle();
		System.out.println(h.strStr("aaaaaaaaaaaaaaaaaaab", "aab"));
	}

	public int strStr(String haystack, String needle) {
		int m = haystack.length(), n = needle.length();
		char c1[] = haystack.toCharArray();
		char c2[] = needle.toCharArray();
		if (m < n)
			return -1;
		int j = 0;
		for (int i = 0; i < m - n + 1; i++) {
			j = 0;
			while (j < n && (j + i) < m && c1[i + j] == c2[j])
				j++;
			if (j == n)
				return i;
		}
		return -1;
	}
}
