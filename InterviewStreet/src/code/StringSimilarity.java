package code;

import java.util.Scanner;

public class StringSimilarity {
	public static void main(String[] args) {
		// helpers for input/output
		Scanner in = new Scanner(System.in);

		int N;
		N = in.nextInt();
		long n = 0;
		StringSimilarity s = new StringSimilarity();
		for (int i = 0; i < N; i++) {
			String curStr = in.next();
			n = s.getSuffixCount(curStr);
			System.out.println(n);
		}
	}

	public long getSuffixCount(String curStr) {
		char str[] = curStr.toCharArray();
		long n = 0;
		for (int i = 0; i < curStr.length(); i++) {
			if (str[0] == str[i])
				n += getPrefixMatchingCount(str, i);
		}
		return n;
	}

	public int getPrefixMatchingCount(char str[], int i) {
		int n = 0, j = 0;
		while (i < str.length && str[i] == str[j]) {
			n++;
			i++;
			j++;
		}
		return n;
	}
}
