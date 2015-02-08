package com.code.strings;
public class IsPalindrome {
	/**
	 * Check if the given number is palindrome or not.
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		String s = Integer.toString(x);
		int n = s.length() - 1;
		int i = 0;
		while (i < n) {
			if (s.charAt(i) != s.charAt(n))
				return false;
			i++;
			n--;
		}
		return true;
	}
}