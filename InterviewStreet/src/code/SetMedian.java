package code;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Set does not allow duplicates.Have to think of some good solutions
 * 
 * @author Dhass
 * 
 */
public class SetMedian {
	public static void main(String[] args) {

		// helpers for input/output
		Scanner in = new Scanner(System.in);
		int N;
		N = in.nextInt();

		String s[] = new String[N];
		int x[] = new int[N];
		for (int i = 0; i < N; i++) {
			s[i] = in.next();
			x[i] = in.nextInt();
		}

		TreeSet<Integer> set = new TreeSet<Integer>();
		SetMedian m = new SetMedian();
		for (int i = 0; i < N; i++) {
			if (s[i].equals("a")) {
				set.add(x[i]);
				// Call median
				m.findMedian(set);
			} else {
				if (!set.contains(x[i]))
					System.out.println("Wrong!");
				else {
					set.remove(new Integer(x[i]));
					// call median
					if (set.isEmpty())
						System.out.println("Wrong!");
					else
						m.findMedian(set);
				}
			}
		}

	}

	// Function to find the median in the list
	public void findMedian(TreeSet<Integer> set) {
		int p = 0, r = set.size() - 1;
		if (set.size() % 2 == 1) {
			// Odd length
			int medPos = p + (r - p) / 2;
			int i = 0, medianElmt = 0;
			for (Integer elmt : set) {
				if (i == medPos) {
					medianElmt = elmt;
					break;
				}
				i++;
			}
			System.out.println(medianElmt);
		} else {
			// Even length medians
			int m1 = ((set.size()) / 2) - 1;
			int m2 = m1 + 1;
			int i = 0;
			int medianElmt1 = 0, medianElmt2 = 0;
			for (Integer elmt : set) {
				if (i == m1) {
					medianElmt1 = elmt;
				}
				if (i == m2) {
					medianElmt2 = elmt;
					break;
				}
				i++;
			}
			double medianElmt = (double) (medianElmt1 + medianElmt2) / 2;
			System.out.println(medianElmt);
		}
	}
}
