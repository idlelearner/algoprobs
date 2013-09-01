package code;

import java.util.HashMap;
import java.util.Scanner;

public class StringReduction {
	public static void main(String[] args) {
		// helpers for input/output
		Scanner in = new Scanner(System.in);
		
		int N;
		N = in.nextInt();
		String inputs[] = new String[N];
		for (int i = 0; i < N; i++) {
			inputs[i] = in.next();
		}

		for (int i = 0; i < N; i++) {
			String curStr = inputs[i];
			int l = 0;
			while (true) {
				l = curStr.length();
				curStr = curStr.replaceAll("ab", "c");
				curStr = curStr.replaceAll("ba", "c");
				curStr = curStr.replaceAll("bc", "a");
				curStr = curStr.replaceAll("cb", "a");
				curStr = curStr.replaceAll("ac", "b");
				curStr = curStr.replaceAll("ca", "b");
				if (l == curStr.length()) {
					System.out.println(curStr.length());
					break;
				}
			}
		}
	}
}
