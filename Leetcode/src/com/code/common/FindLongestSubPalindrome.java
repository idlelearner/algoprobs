package com.code.common;
/**
 * https://oj.leetcode.com/problems/longest-palindromic-substring/
 * 
 * @author thiru022
 *
 */
public class FindLongestSubPalindrome {

	public static void main(String[] args) {
		FindLongestSubPalindrome f = new FindLongestSubPalindrome();
		System.out.println(f.longestPalindrome("bb"));
	}

	public String longestPalindrome(String s) {
		if (s.length() == 1)
			return s;
		char c[] = s.toCharArray();
		String pal = "";
		for (int i = 0; i < c.length; i++) {
			String newPal = getPalindrome(c, i);
			if (pal.length() < newPal.length())
				pal = newPal;
		}
		return pal;
	}

	public String getPalindrome(char c[], int i) {
		int j = i + 1;
		if (j >= c.length)
			return new String("" + c[i] + "");
		if (j < c.length && c[i] != c[j]) {
			i--;
		}
		while (i >= 0 && j < c.length) {
			if (c[i] == c[j]) {
				i--;
				j++;
			} else
				break;
		}
		i = i + 1;
		j = j - 1;
		char v[] = new char[j - i + 1];
		int k = 0;
		while (i <= j) {
			v[k] = c[i];
			k++;
			i++;
		}
		return new String(v);
	}
}
