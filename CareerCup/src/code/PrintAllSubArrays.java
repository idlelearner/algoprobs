package code;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintAllSubArrays {
	public static void main(String[] args) {
		int a[] = { 1, -1, 4, -4 };
		PrintAllSubArrays p = new PrintAllSubArrays();
		p.printSubArraysSumZero(a);
	}

	public void printSubArraysSumZero(int a[]) {
		int s[] = new int[a.length];
		int l = a.length;
		for (int i = 0; i < l; i++) {
			if (i == 0)
				s[i] = a[i];
			else
				s[i] = s[i - 1] + a[i];
		}
		HashMap<Integer, ArrayList<Integer>> h = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> t = new ArrayList<Integer>();
		t.add(-1);
		h.put(0, t);
		for (int i = 0; i < l; i++) {
			//If the key is present,then print the values from the hash value to current elmt
			if (h.containsKey(s[i])) {
				for (Integer v : h.get(s[i]))
					printArray(a, v + 1, i);
				h.get(s[i]).add(i);
			} else {
				ArrayList<Integer> in = new ArrayList<Integer>();
				in.add(i);
				h.put(s[i], in);
			}
		}
	}

	public void printArray(int a[], int i, int j) {
		for (int n = i; n <= j; n++)
			System.out.print(a[n] + " ");
		System.out.println();
	}
}
