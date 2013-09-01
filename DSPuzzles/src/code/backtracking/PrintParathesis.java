package code.backtracking;

public class PrintParathesis {
	public static char[] str;

	public static void main(String[] args) {
		PrintParathesis p = new PrintParathesis();
		p.printparenthesis(3);
	}

	void printparenthesisRecur(int n, int open, int close, char str[], int len) {
		if (len == 2 * n) {
			str[len] = '\0';
			System.out.println(str);
		}
		if (open < n) {
			str[len++] = '(';
			printparenthesisRecur(n, open + 1, close, str, len);
			len--;
		}
		if (close < n && close < open) {
			str[len++] = ')';
			printparenthesisRecur(n, open, close + 1, str, len);
			len--;
		}
	}

	void printparenthesis(int n) {
		str = new char[2 * n + 1];
		printparenthesisRecur(n, 0, 0, str, 0);
	}
}
