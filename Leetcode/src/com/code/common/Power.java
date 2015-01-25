package com.code.common;
public class Power {
	public static void main(String[] args) {
		Power p = new Power();
		System.out.println((double) p.pow(8.88023, 3));
	}

	public double pow(double x, int n) {
		if (n == 0)
			return 1;
		double v = pow(x, n / 2);
		if (n % 2 == 0)
			return (v * v);
		else {
			if (n < 0)
				return v * v / x;
			else
				return v * v * x;
		}

	}
}
