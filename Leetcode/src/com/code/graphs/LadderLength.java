package com.code.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LadderLength {

	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		String[] s1 = { "hot", "cog", "dot", "dog", "hit", "lot", "log" };
		for (String t : s1)
			s.add(t);
		LadderLength l = new LadderLength();
		System.out.println(l.ladderLength("hit", "cog", s));
	}

	public int ladderLength(String start, String end, Set<String> dict) {
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		String abc = "abcdefghijklmnopqrstuvwxyz";
		for (String s : dict) {
			visited.put(s, false);
			map.put(s, new ArrayList<String>());
			for (int i = 0; i < s.length(); i++) {
				char c[] = s.toCharArray();
				for (int j = 0; j < 26; j++) {
					c[i] = abc.charAt(j);
					String ns = new String(c);
					if (!ns.equals(s) && dict.contains(ns))
						map.get(s).add(ns);
				}
			}
		}

		// Traverse and find the Shortest String
		ArrayDeque<String> q = new ArrayDeque<String>();
		int count = 0;
		q.add(start);
		while (!q.isEmpty()) {
			String c = q.pollFirst();
			if(!visited.get(c)){
				visited.put(c, true);
				count++;
				for (String n : map.get(c)) {
					if (n.equals(end))
						return count;
					if (!visited.get(n))
						q.add(n);
				}
			}
		}

		return 0;
	}
}
