package code.string;

public class AdjacentPairs {
	public static void main(String[] args) {
		AdjacentPairs a = new AdjacentPairs();
		char[] cArr = new String("ABCCBCBA").toCharArray();
		System.out.println(cArr);
		a.removeAdjacentPairs(cArr, cArr.length - 1);
		System.out.println(cArr);
	}

	public void removeAdjacentPairs(char[] s, int len) {
		int j = 0;
		for (int i = 1; i <= len; i++) {
			while (s[i] == s[j] && j >= 0) {
				i++;
				j--;
			}
			s[++j] = s[i];
		}
	}
}
