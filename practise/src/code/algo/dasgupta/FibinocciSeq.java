package code.algo.dasgupta;

public class FibinocciSeq {
	public static void main(String[] args) {
		FibinocciSeq f = new FibinocciSeq();
		System.out.println(f.fib(20));
		System.out.println(f.fibRec(20));
	}

	public long fib(int n) {
		long a = 1, b = 1;
		for (int i = 1; i <= n; i++) {
			long t = a;
			a = b;
			b = t + b;
		}
		return a;

	}

	public long fibRec(int n) {
		if (n == 0 || n == 1)
			return 1;
		return fibRec(n - 1) + fibRec(n - 2);
	}
}
