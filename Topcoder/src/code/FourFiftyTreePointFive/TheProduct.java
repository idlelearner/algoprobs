package code.FourFiftyTreePointFive;

public class TheProduct {
	public static void main(String[] args) {
		// int num[] = { 7, 4, 7 };
		int num[] = { -3, -5, -8, -9, -1, -2 };
		TheProduct p = new TheProduct();
		System.out.println(p.maxProduct(num, 3, 3));
	}

	long maxProduct(int[] numbers, int k, int maxDist) {
		int n = numbers.length;
		long mi[][] = new long[n + 1][n + 1];
		long ma[][] = new long[n + 1][n + 1];
		long mm, mmm;
		mm = ((long) 1 << 61);
		mmm = -((long) 1 << 61);
		long mi2 = mm;
		long ma2 = mmm;
		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < n + 1; j++) {
				mi[i][j] = mm;
				ma[i][j] = -mmm;
			}
		for (int i = 0; i < numbers.length; i++) {
			mi[i][1] = numbers[i];
			ma[i][1] = numbers[i];
		}

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 2; j <= k; j++) {
				if (i == 0) {
					mi[0][j] = ((long) 1 << 61);
					ma[0][j] = -((long) 1 << 61);
					continue;
				}
				mm = mi2;
				mmm = ma2;
				for (int x = i - 1; x >= 0 && i - x <= maxDist; x--) {
					if (numbers[i] > 0) {
						if (mi[x][j - 1] < mi2)
							if (mi[x][j - 1] * numbers[i] < mm)
								mm = mi[x][j - 1] * numbers[i];
						if (ma[x][j - 1] > ma2)
							if (ma[x][j - 1] * numbers[i] > mmm) {
								mmm = ma[x][j - 1] * numbers[i];
							}
					} else {
						if (mi[x][j - 1] < mi2)
							if (mi[x][j - 1] * numbers[i] > mmm)
								mmm = mi[x][j - 1] * numbers[i];
						if (ma[x][j - 1] > ma2)
							if (ma[x][j - 1] * numbers[i] < mm)
								mm = ma[x][j - 1] * numbers[i];
					}

				}
				mi[i][j] = mm;
				ma[i][j] = mmm;
			}
		}
		long total = ma2;
		for (int i = 0; i < numbers.length; i++)
			if (ma[i][k] > total)
				total = ma[i][k];
		return total;
	}
}
