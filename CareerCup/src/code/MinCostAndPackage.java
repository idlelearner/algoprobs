package code;

public class MinCostAndPackage {
	public static void main(String[] args) {
		MinCostAndPackage m = new MinCostAndPackage();
		int q[] = { 1, 2, 3, 4, 5, 6 };
		int p[] = { 10, 15, 20, 25, 30, 35 };
		m.findMinCostAndQuantity(q, p, 10);
	}

	public void findMinCostAndQuantity(int q[], int p[], int tot) {
		int c[] = new int[tot + 1];
		int price[] = new int[tot + 1];
		for (int i = 0; i <= tot; i++) {
			c[i] = i;
			price[i] = 10000000;
		}
		for (int i = 1; i <= tot; i++) {
			for (int j = 0; j < q.length && q[j] <= i; j++) {
				if (i == q[j] && price[i] > p[j]) {
					c[i] = 1;
					price[i] = p[j];
				}
				if ((price[i] > price[i - q[j]] + p[j])
						|| (price[i] == price[i - q[j]] + p[j] && (c[i] > c[i
								- q[j]] + 1))) {

					price[i] = price[i - q[j]] + p[j];
					c[i] = c[i - q[j]] + 1;
				}
			}
		}
		System.out.println(c[tot]);
		System.out.println(price[tot]);
	}
}
