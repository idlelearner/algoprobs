package com.code.common;

/**
 * Convert string into integer
 * 
 * @author dhass
 *
 */
public class Atoi {

	public static void main(String[] args) {
		Atoi a = new Atoi();
		System.out.println(a.atoi("    10522545459"));
	}

	public int atoi(String str) {
		if (str.length() == 0)
			return 0;
		str = str.trim();
		boolean negative = false;
		double n = 0;
		if (str.charAt(0) == '-') {
			negative = true;
			str = str.substring(1);
		} else if (str.charAt(0) == '+') {
			negative = false;
			str = str.substring(1);
		}

		int l = str.length();

		for (int i = 0; i < l; i++) {
			if (Character.isDigit(str.charAt(i))) {
				n = n * 10 + Integer.parseInt("" + str.charAt(i));
			} else if (str.charAt(i) == '-' || str.charAt(i) == '+')
				return 0;
			else
				break;
		}

		n = negative ? -1 * n : n;
		if (n > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (n < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) n;

	}
}
