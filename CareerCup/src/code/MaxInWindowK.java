package code;

import java.util.ArrayDeque;

public class MaxInWindowK {
	public static void main(String[] args) {
		MaxInWindowK m = new MaxInWindowK();
		int a[] = { 6, 5, 4, 3, 7, 2, 1 };
		m.maxInWindow(a, 3);
	}

	void maxInWindow(int arr[], int k) {

		ArrayDeque<Integer> Qi = new ArrayDeque<Integer>();
		int i;
		for (i = 0; i < k; i++) {
			while (!Qi.isEmpty() && arr[i] >= arr[Qi.getLast()]) {
				Qi.removeLast();
			}
			Qi.addLast(i);
		}

		for (; i < arr.length; i++) {
			//System.out.println(arr[Qi.getFirst()]);
			while (!Qi.isEmpty() && i - k >= Qi.getFirst()) {
				Qi.removeFirst();
			}

			while (!Qi.isEmpty() && arr[i] >= arr[Qi.getLast()]) {
				Qi.removeLast();
			}
			Qi.addLast(i);
		}
		System.out.println(arr[Qi.getFirst()]);
	}
}
