package code.type;

import java.util.ArrayList;
import java.util.Arrays;

public class GeneratePrimeNo {
	public static void main(String[] args) {
		GeneratePrimeNo g = new GeneratePrimeNo();
		long st = System.currentTimeMillis();
		ArrayList<Integer> p = g.generatePrimeNoTillN(100);
		long en = System.currentTimeMillis();
		// System.out.println(en-st);
		for (Integer i : p)
			System.out.print(i + " ");
	}

	public ArrayList<Integer> generatePrimeNoTillN(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int s = (int) (Math.floor(0.5 * (n - 3)) + 1);
		boolean isPrime[] = new boolean[n];
		Arrays.fill(isPrime, true);
		primes.add(2);
		for (int i = 0; i < s; i++) {
			if (isPrime[i]) {
				// 2i+3
				int p = (i << 1) + 3;
				primes.add(p);
				for (long j = ((i * i) << 1) + 6 * i + 3; j < s; j += p) {
					if (j >= 0)
						isPrime[(int) j] = false;
				}
			}
		}
		return primes;
	}
}
