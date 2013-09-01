package code.match;

public class ShorterSuperSum {
	public int sum = 0;

	public static void main(String[] args) {
		ShorterSuperSum s = new ShorterSuperSum();
		System.out.println(s.calculate(2, 3));
	}

	public int calculate(int k, int n) {
		if (k == 0)
			return n;
		if (n > 0)
			return calculate(k, n - 1) + calculate(k - 1, n);
		return 0;
	}
}