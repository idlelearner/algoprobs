package com.code.easy;

/**
 * Print multiplication table and format it.
 * 
 * @author thiru022
 *
 */
public class MultTable {
	int SPACES = 4;

	public static void main(String[] args) {
		MultTable m = new MultTable();
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 12; j++) {
				int n = i * j;
				System.out.print(m.getString(n));
			}
			System.out.println("");
		}
	}

	/**
	 * Get number of digits.
	 * 
	 * @param n
	 * @return
	 */
	public int getNoOfDigits(int n) {
		int v = 0;
		while (n != 0) {
			v++;
			n /= 10;
		}
		return v;
	}

	/**
	 * Get the formatted string.
	 * 
	 * @param n
	 * @return
	 */
	public String getString(int n) {
		int d = getNoOfDigits(n);
		int s = SPACES - d;
		StringBuilder sb = new StringBuilder();
		while (s-- != 0)
			sb.append(" ");
		sb.append(n);
		return sb.toString();
	}

}
