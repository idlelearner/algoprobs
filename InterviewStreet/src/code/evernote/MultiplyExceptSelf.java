package code.evernote;

import java.util.Scanner;

public class MultiplyExceptSelf {

	public static void main(String[] args) {
		// helpers for input/output
		Scanner in = new Scanner(System.in);

		int N;
		N = in.nextInt();

		long num[] = new long[N];
		for (int i = 0; i < N; i++) {
			num[i] = in.nextLong();
		}
		long product = 1;
		for (int i = 0; i < N; i++) {
			product *= num[i];
		}
		for (int i = 0; i < N; i++) {
			if (num[i] == 0) {
				long zeroElmtProduct = 1;
				for (int j = 0; j < N; j++)
					if (j != i)
						zeroElmtProduct *= num[j];
				System.out.println(zeroElmtProduct);
			} else {
				long multiplyExceptSelf = product / num[i];
				System.out.println(multiplyExceptSelf);
			}
		}
	}
}
