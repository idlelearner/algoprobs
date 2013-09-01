package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 20 point problem in interviewstreet - solved
 * @author Dhass
 *
 */
class Flowers {
	public static void main(String args[]) {
		// helpers for input/output
		Scanner in = new Scanner(System.in);

		int N, K;
		N = in.nextInt();
		K = in.nextInt();

		ArrayList<Integer> cost = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			cost.add(in.nextInt());
		}

		Collections.sort(cost, Collections.reverseOrder());
		Flowers flowers = new Flowers();
		long result = flowers.getMinCost(cost, K);
		System.out.println(result);

	}

	// Min cost to be spend to buy all the flowers by K friends
	long getMinCost(List<Integer> cost, int K) {
		long minCost = 0;
		for (int i = 0; i < cost.size(); i++) {
			int val = cost.get(i);
			minCost += (Math.floor((i) / K) + 1) * val;
		}
		return minCost;
	}
}
