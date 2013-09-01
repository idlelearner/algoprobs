package code.match;

public class FoxAndFlowerShopDivTwo {
	public static void main(String[] args) {
		String[] flowers = { "F..", "...", "..." };
		FoxAndFlowerShopDivTwo f = new FoxAndFlowerShopDivTwo();
		System.out.println(f.theMaxFlowers(flowers, 0, 0));
	}

	public int theMaxFlowers(String[] flowers, int r, int c) {
		int m = flowers.length;
		int n = flowers[0].length();
		int val = 0;
		int val1 = findNumberOfFlowers(flowers, 0, 0, r - 1, n - 1);
		int val2 = findNumberOfFlowers(flowers, r + 1, 0, m - 1, n - 1);
		int val3 = findNumberOfFlowers(flowers, 0, 0, m - 1, c - 1);
		int val4 = findNumberOfFlowers(flowers, 0, c + 1, m - 1, n - 1);
		val = val1;
		if (val2 > val)
			val = val2;
		if (val3 > val)
			val = val3;
		if (val4 > val)
			val = val4;
		return val;
	}

	public int findNumberOfFlowers(String[] flowers, int x1, int y1, int x2,
			int y2) {
		int m = flowers.length;
		int n = flowers[0].length();
		int count = 0;
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (i < 0 || i >= m || j < 0 || j >= n)
					break;
				if (flowers[i].charAt(j) == 'F')
					count++;
			}
		}
		return count;
	}
}
