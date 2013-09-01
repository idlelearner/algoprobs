package code.backtracking;

public class MinPalPartitionProb {
	public static void main(String[] args) {
		MinPalPartitionProb m = new MinPalPartitionProb();
		String a = "ababbbabbababa";
		System.out.println(m.minPalPartition(a, 0, a.length() - 1));
	}

	int minPalPartition(String a, int i, int j) {
		int count = 0, min = Integer.MAX_VALUE;
		if (i == j || isPalindrome(a, i, j))
			return 0;
		for (int k = i; k < j; k++) {
			count = minPalPartition(a, i, k) + 1 + minPalPartition(a, k + 1, j);
			if (min > count)
				min = count;
		}
		return min;
	}

	boolean isPalindrome(String a, int i, int j) {
		while (a.charAt(i) == a.charAt(j)) {
			if (i == j || i > j)
				return true;
			i++;
			j--;
		}
		return false;
	}
}
