package com.code.common;
public class ReverseInt {

	/**
	 * Reverse the the given number
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseInt r = new ReverseInt();
		System.out.println(r.reverse(-123));
	}

	public int reverse(int x) {
		if (x == 0)
			return x;
		boolean negative = false;
		if (x < 0)
			negative = true;
		double rev = 0;
		while (x != 0) {
			rev = rev * 10 + Math.abs(x % 10);
			x = x / 10;
		}

		rev = negative ? -1 * rev : rev;
		if (rev > Integer.MAX_VALUE)
			return 0;
		if (rev < Integer.MIN_VALUE)
			return 0;

		return (int) rev;
	}
}
