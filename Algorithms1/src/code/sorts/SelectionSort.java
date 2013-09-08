package code.sorts;

import java.util.Arrays;

/**
 * Selection sort implementation. Choose the minimum most element for iteration
 * and place it in order.
 * 
 * @author Dhass
 * 
 */
public class SelectionSort {

	public int[] sort(int a[]) {
		int l = a.length;
		
		for (int i = 0; i < l; i++) {
			int min = i;
			for (int j = i; j < l; j++) {
				if (a[min] > a[j])
					min = j;
			}

			int t = a[i];
			a[i] = a[min];
			a[min] = t;
		}
		return a;
	}

	public static void main(String[] args) {
		SelectionSort s = new SelectionSort();
		int a[] = { 4, 6, 1, 1, 3, 9 };
		System.out.println(Arrays.toString(s.sort(a)));
	}
}