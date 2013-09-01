package code.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all anagrams in the given list
 * 
 * @author Dhass
 * 
 */
public class Anagrams {
	private static Map<String, List<String>> anagramsMap = new HashMap<>(100);

	public static void main(String[] args) {
		String[] input = { "akka", "akak", "baab", "baba", "bbaa" };
		for (String s : input) {
			char[] word = s.toCharArray();
			Arrays.sort(word);
			String key = String.valueOf(word);
			if (!anagramsMap.containsKey(key)) {
				anagramsMap.put(key, new ArrayList<String>());
			}
			anagramsMap.get(key).add(s);
		}
		System.out.println("anagramsMap = " + anagramsMap);
	}
}