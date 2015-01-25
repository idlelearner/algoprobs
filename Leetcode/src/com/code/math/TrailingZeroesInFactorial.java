package com.code.math;

/**
 * Find the number of trailing zeros in the factorial of the number. which is
 * equal to total of number of 5,25,125,625... in the given number.
 * 
 * @author dhass
 *
 */
public class TrailingZeroesInFactorial {
	public int trailingZeroes(int n) {
		int v = 0;
		long c = 5;
		while (c <= n) {
			v += n / c;
			c = c * 5;
		}
		return v;
	}
}
