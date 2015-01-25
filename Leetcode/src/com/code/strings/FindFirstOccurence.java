package com.code.strings;

import java.util.ArrayList;
import java.util.List;

public class FindFirstOccurence {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < L.length; i++) {
			res.add(S.indexOf(L[i]));
		}
		return res;
	}
}
