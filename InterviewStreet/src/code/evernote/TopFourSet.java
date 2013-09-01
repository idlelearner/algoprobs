package code.evernote;

import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class TopFourSet {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N;
		N = in.nextInt();

		TreeSet<Integer> nums = new TreeSet<Integer>(Collections.reverseOrder());
		// nums.first();
		// nums.last();
		for (int i = 0; i < N; i++) {
			nums.add(in.nextInt());
		}
		Iterator<Integer> iterator = nums.iterator();
		int count = 1;
		while (iterator.hasNext() && count <= 4) {
			System.out.println(iterator.next());
			count++;
		}
	}
}
