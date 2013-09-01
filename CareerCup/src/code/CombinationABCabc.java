package code;

public class CombinationABCabc {
	public static void main(String[] args) {
		char[] a = { 'A', 'B', 'C' };
		char[] b = { 'a', 'b', 'c' };
		int n = a.length;
		int p = (int) Math.pow(2, n);
		for (int i = 0; i < p; i++) {
			for (int k = 0; k < n; k++) {
				int v = i & 1 << n - 1 - k;
				System.out.print(v == 0 ? a[k] : b[k]);
			}
			System.out.println();
		}

		CombinationABCabc c = new CombinationABCabc();
		c.truthTable(2);
	}

	public void truthTable(int n) {
		long p = (int) Math.pow(2, n);
		for (long i = 0; i < p; i++) {
			for (int k = 0; k < n; k++) {
				long v = i & 1 << n - 1 - k;
				System.out.print(v == 0 ? "T" : "F");
			}
			System.out.println();
		}
	}
}
