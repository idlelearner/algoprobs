package code;

public class ReverseSentence {
	public static void main(String[] args) {
		String a = "Today is Wednesday";
		a = a.trim();
		char[] cArr = a.toCharArray();
		ReverseSentence r = new ReverseSentence();
		r.reverse(cArr, 0, cArr.length - 1);
		int s = 0;
		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] == ' ') {
				r.reverse(cArr, s, i - 1);
				s = i + 1;
			}
			// call for the last word in the sentence
			if (i == cArr.length - 1)
				r.reverse(cArr, s, i);
		}
		System.out.println(cArr);
	}

	public void reverse(char c[], int i, int j) {
		char t;
		while (i < j) {
			t = c[i];
			c[i] = c[j];
			c[j] = t;
			i++;
			j--;
		}
	}
}
