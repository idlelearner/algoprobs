package com.code.dynamicprogramming;

/**
 * Find the cost to transform one string to other.
 * 
 * @author thirunavukarasu
 * 
 */
public class EditDistance {
	public static void main(String[] args) {
		EditDistance e = new EditDistance();
		System.out.println(e.minDistance("ab", "bc"));
	}

	public int minDistance(String word1, String word2) {
		if (word1.length() == 0)
			return word2.length();
		if (word2.length() == 0)
			return word1.length();

		int ed[][] = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++)
			ed[i][0] = i;
		for (int j = 0; j <= word2.length(); j++)
			ed[0][j] = j;
		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				if (word1.charAt(i) == word2.charAt(j))
					ed[i + 1][j + 1] = ed[i][j];
				else {
					int d = ed[i + 1][j] + 1;
					int r = ed[i][j] + 1;
					int in = ed[i][j + 1] + 1;
					int min = Math.min(Math.min(d, r), in);
					ed[i + 1][j + 1] = min;
				}
			}
		}
		return ed[word1.length()][word2.length()];
	}
}
