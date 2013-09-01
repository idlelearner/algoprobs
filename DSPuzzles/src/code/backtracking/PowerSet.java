package code.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * PowerSet of a set using recursion - Similar to combination
 * 
 * @author Dhass
 * 
 */
public class PowerSet {
	int count;

	public static void main(String[] args) {
		PowerSet p = new PowerSet();
		p.count = 0;
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		p.powerSet(new int[l.size()], 0, l);
		System.out.println(p.count);
	}

	public void powerSet(int powSet[], int t, List<Integer> set) {
		// System.out.println(Arrays.toString(powSet));
		for (int i = 0; i < t; i++)
			System.out.print(powSet[i] + " ");
		System.out.println();
		count++;
		for (int i = 0; i < set.size(); i++) {
			powSet[t] = set.get(i);
			powerSet(powSet, t + 1, set.subList(i + 1, set.size()));
		}
	}
}
