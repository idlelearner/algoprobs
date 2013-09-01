package code;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Find pairs with sum K - solved
 * @author Dhass
 *
 */
public class KDifference {
	public static void main(String[] args) {
		// helpers for input/output
		Scanner in = new Scanner(System.in);

		int N, K;
		N = in.nextInt();
		K = in.nextInt();

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		KDifference diff = new KDifference();
		System.out.println(diff.getKDifferencePairsCount(arr, K));
	}

	int getKDifferencePairsCount(int[] arr, int K) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for (int a : arr)
			map.put(a, a);
		for (int a : arr) {
			if (map.get(K + a) != null)
				count++;
		}
		return count;
	}
}
