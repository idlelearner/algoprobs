package code;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MedianList {
	public static void main(String[] args) {
		// helpers for input/output
		Scanner in = new Scanner(System.in);
		int N;
		N = in.nextInt();

		String s[] = new String[N];
		long x[] = new long[N];
		for (int i = 0; i < N; i++) {
			s[i] = in.next();
			x[i] = in.nextLong();
		}
		ArrayList<Long> sortedList = new ArrayList<Long>();
		for (int i = 0; i < N; i++) {
			int index = Collections.binarySearch(sortedList, x[i]);
			if (s[i].equals("r")) {
				if (index < 0) {
					System.out.println("Wrong!");
					continue;
				} else
					sortedList.remove(index);
			} else {
				if (index < 0)
					sortedList.add(-index - 1, x[i]);
				else
					sortedList.add(index, x[i]);
			}
			if (sortedList.isEmpty())
				System.out.println("Wrong!");
			if (sortedList.size() % 2 == 1)
				System.out.println(sortedList.get((sortedList.size() - 1) / 2));
			if (!sortedList.isEmpty() && sortedList.size() % 2 == 0) {
				long elmt1 = sortedList.get(sortedList.size() / 2);
				long elmt2 = sortedList.get((sortedList.size() / 2) - 1);
				double median = (double) (elmt1 + elmt2) / 2;
				DecimalFormat df = new DecimalFormat("#.#");
				System.out.println(df.format(median));
			}
		}
	}
}
