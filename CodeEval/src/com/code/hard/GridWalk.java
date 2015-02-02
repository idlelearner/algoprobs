package com.code.hard;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.codeeval.com/open_challenges/60/ How to maintain visited notes
 * efficiently ans : 102485
 * 
 * @author thiru022
 *
 */

public class GridWalk {
	// Set to keep track of visited nodes
	Set<BitSet> visitedSet = new HashSet<>();

	public static void main(String[] args) {
		GridWalk g = new GridWalk();
		g.getBitSet(298, 298);
		System.out.println(g.getMonkeyWalkCount(0, 0));
	}

	public int getMonkeyWalkCount(Integer x, Integer y) {
		if (allowedCell(x, y) && !visitedSet.contains(getBitSet(x, y))) {
			visitedSet.add(getBitSet(x, y));
			return 1 + getMonkeyWalkCount(x + 1, y)
					+ getMonkeyWalkCount(x - 1, y)
					+ getMonkeyWalkCount(x, y + 1)
					+ getMonkeyWalkCount(x, y - 1);
		} else
			return 0;
	}

	/**
	 * Gets the bitset of v1v2
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public BitSet getBitSet1(int v1, int v2) {
		String a = Integer.toBinaryString(v1);
		int al = a.length();
		a = a.substring(al - 10 < 0 ? 0 : al - 10, al);
		String b = Integer.toBinaryString(v2);
		int bl = b.length();
		b = b.substring(bl - 10 < 0 ? 0 : bl - 10, bl);
		BitSet v = new BitSet(64);
		int j = 21;
		for (int i = a.length() - 1; i >= 0; i--) {
			v.set(--j, a.charAt(i) == '1');
		}
		j = 11;
		for (int i = b.length() - 1; i >= 0; i--) {
			v.set(--j, b.charAt(i) == '1');
		}
		return v;
	}

	public BitSet getBitSet(int v1, int v2) {

		BitSet v = new BitSet(30);
		int j = 31;
		for (int i = Math.abs(v1); i > 0; i = i / 2) {
			v.set(--j, (i % 2 == 1));
		}
		if (v1 < 0)
			v.set(--j, true);
		j = 51;
		for (int i = Math.abs(v2); i > 0; i = i / 2) {
			v.set(--j, (i % 2 == 1));
		}
		if (v2 < 0)
			v.set(--j, true);
		return v;
	}

	/**
	 * Check if the given given co ordinates sum is less than or equal to 0.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean allowedCell(int x, int y) {
		int xVal = getSumOfDigits(Math.abs(x));
		int yVal = getSumOfDigits(Math.abs(y));
		return (xVal + yVal) <= 19;
	}

	/**
	 * Get sum of digits of a number
	 * 
	 * @param n
	 * @return
	 */
	public int getSumOfDigits(int n) {
		int v = 0;
		while (n != 0) {
			v += n % 10;
			n /= 10;
		}
		return v;
	}
}
