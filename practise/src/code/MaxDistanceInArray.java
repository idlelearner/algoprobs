package code;

import java.util.TreeSet;

/**
 * Find the max distance of the same elmt in the given array
 * 
 * @author Dhass
 * 
 */
public class MaxDistanceInArray {
	public static void main(String[] args) {
		MaxDistanceInArray m = new MaxDistanceInArray();
		int a[] = { 1, 2, 3, 4, 1, 1, 7, 4 };
		m.maxDistance(a);
	}

	public void maxDistance(int a[]) {
		TreeSet<Integer> t = new TreeSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (!t.contains(a[i])) {
				int j = a.length - 1;
				while (j >= i) {
					if (a[i] == a[j]) {
						t.add(a[i]);
						System.out.println("Max(" + a[i] + ")= " + (j - i));
						break;
					}
					j--;
				}
			}
		}
	}
}
