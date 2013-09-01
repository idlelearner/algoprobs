package code;

public class RegExMatching {
	public static void main(String[] args) {
		RegExMatching r = new RegExMatching();
		String first = "**bc";
		String second = "bc";
		System.out.println(r.matchExp(first.toCharArray(),
				second.toCharArray(), 0, 0));
	}

	boolean matchExp(char exp[], char str[], int i, int j) {

		if (i == exp.length && j == str.length)
			return true;

		if ((i == exp.length && j != str.length)
				|| (i != exp.length && j == str.length))
			return false;

		if (exp[i] == '?' || exp[i] == str[j])
			return matchExp(exp, str, i + 1, j + 1);

		if (exp[i] == '*')
			return matchExp(exp, str, i + 1, j) || matchExp(exp, str, i, j + 1)
					|| matchExp(exp, str, i + 1, j + 1);
		return false;
	}
}
