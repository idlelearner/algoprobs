package code.recursion;

public class Factorial {
	public static void main(String[] args) {
		Factorial f = new Factorial();
		System.out.println(f.fact(7));
	}

	public long fact(int n) {
		if (n == 1)
			return 1;
		return n * fact(n - 1);
	}
}
