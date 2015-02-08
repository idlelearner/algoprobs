package com.code.twoptrs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find the quadruplets whose sum is equal to target.
 * 
 * @author thirunavukarasu
 *
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		HashMap<Integer, ArrayList<Node>> valueMap = new HashMap<Integer, ArrayList<Node>>();
		if (num.length < 4)
			return res;
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int v = num[i] + num[j];
				if (!valueMap.containsKey(v))
					valueMap.put(v, new ArrayList<Node>());
				valueMap.get(v).add(new Node(i, j));
				int t = target - v;
				if (valueMap.containsKey(t)) {
					for (Node n : valueMap.get(t)) {
						if (n.x != i && n.x != j && n.y != i && n.y != j) {
							List<Integer> l = new ArrayList<Integer>();
							l.add(num[i]);
							l.add(num[j]);
							l.add(num[n.x]);
							l.add(num[n.y]);
							Collections.sort(l);
							res.add(l);
						}
					}
				}
			}
		}
		Set<List<Integer>> s = new HashSet<List<Integer>>();
		s.addAll(res);
		List<List<Integer>> res1 = new ArrayList<List<Integer>>();
		res1.addAll(s);
		return res1;
	}
}

class Node {
	int x, y;

	public Node(int a, int b) {
		x = a;
		y = b;
	}
}