package code.evernote;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class ValueComparator implements Comparator<String> {

	Map<String, Integer> base;

	public ValueComparator(Map<String, Integer> base) {
		this.base = base;
	}

	public int compare(String a, String b) {
		if (base.get(a) == base.get(b))
			return a.compareTo(b);
		else
			return base.get(b).compareTo(base.get(a));
	}
}

public class FrequentTerms {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N;
		N = in.nextInt();

		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String word = in.next();
			if (wordCount.get(word) != null)
				wordCount.put(word, wordCount.get(word) + 1);
			else
				wordCount.put(word, 1);
		}
		int K = in.nextInt();

		// Sorted Hashmap - implemented using value comparator
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(
				new ValueComparator(wordCount));
		sortedMap.putAll(wordCount);

		int n = 1;
		for (String word : sortedMap.keySet()) {
			System.out.println(word);
			n++;
			if (n > K)
				break;
		}
	}
}
