package com.code.strings;

import java.util.LinkedList;

/**
 * Find longest substring without repeating characters. Use a linkedlist to
 * maintain the substring without repeated characters.
 * 
 * @author dhass
 *
 */
public class LongestSubstrWithoutRepeatingChars {
	public static void main(String[] args) {
		LongestSubstrWithoutRepeatingChars l = new LongestSubstrWithoutRepeatingChars();
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(l.lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		LinkedList<Character> queue = new LinkedList<Character>();
		if (s.length() == 0)
			return 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (queue.contains(c)) {
				while (queue.removeFirst() != c)
					;
			}
			queue.addLast(c);
			if (max < queue.size())
				max = queue.size();
		}
		return max;
	}
}
