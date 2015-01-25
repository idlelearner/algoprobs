package com.code.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Find the given anagrams strings in the given group.
 * 
 * @author thirunavukarasu
 * 
 */
public class FindAnangrams {
	public List<String> anagrams(String[] strs) {
		HashMap<String, List<String>> anagramMap = new HashMap<String, List<String>>();
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < strs.length; i++) {
			char c[] = strs[i].toCharArray();
			Arrays.sort(c);
			String s = new String(c);
			if (!anagramMap.containsKey(s))
				anagramMap.put(s, new ArrayList<String>());
			anagramMap.get(s).add(strs[i]);
		}

		for (String k : anagramMap.keySet()) {
			if (anagramMap.get(k).size() > 1) {
				for (String l : anagramMap.get(k))
					res.add(l);
			}
		}

		return res;
	}
}
