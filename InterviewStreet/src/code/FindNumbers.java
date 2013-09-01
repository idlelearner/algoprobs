package code;

import java.util.Scanner;

public class FindNumbers {
	public static void main(String[] args) {
		// helpers for input/output
		Scanner in = new Scanner(System.in);
		int N;
		N = in.nextInt();
		FindNumbers f = new FindNumbers();
		for (int i = 0; i < N; i++) {
			f.findNumbers(in.nextLong(), in.nextLong());
		}
	}

	public void findNumbers(long val1, long val2) {
		long a = val1, b = 0;
		long right_most_bit_set = val2 & ~(val2 - 1);
		for (long i = 1; i < val1; i++) {
			if (((i & right_most_bit_set) != 0) || val2 == 0) {
				long t = i ^ val2;
				if (t + i == val1) {
					long ta = Math.max(t, i);
					long tb = val1 - ta;
					if ((a - b) > (ta - tb)) {
						a = ta;
						b = tb;
					}
				}
			}
		}
		System.out.println(a + " " + b);
	}
}
