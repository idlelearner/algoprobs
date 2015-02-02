package com.code.easy;

/**
 * Sum of first 1000 primes 
 * submitted
 * 
 * @author dhass
 *
 */
public class SumOfPrimes {
	public static void main(String[] args) {
		SumOfPrimes s = new SumOfPrimes();
		System.out.println(s.getSumOfPrimes());
	}

	public int getSumOfPrimes() {
		int s = 5, c = 2;
		int a[] = new int[1000];
		int j = 0;
		a[0] = 2;
		a[1] = 3;
		for (int i = s; i < Integer.MAX_VALUE; i = i + 2) {
			j = 0;
			while (j < c) {
				if (i % a[j] == 0)
					break;
				j++;
			}
			if (j == c) {
				a[c] = i;
				c++;
				s += i;
			}
			if (c == 1000)
				break;
		}
		return s;
	}
}
