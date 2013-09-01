package code.recursion;

public class Subsets {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		Subsets s = new Subsets();
		s.printPowerSet(a);
	}

	void printPowerSet(int set[]) {
		/*
		 * set_size of power set of a set with set_size n is (2**n -1)
		 */
		int set_size = set.length;
		int pow_set_size = (int) Math.pow(2, set_size);
		int counter, j;

		/* Run from counter 000..0 to 111..1 */
		for (counter = 0; counter < pow_set_size; counter++) {
			for (j = 0; j < set_size; j++) {
				/*
				 * Check if jth bit in the counter is set If set then print jth
				 * element from set
				 */
				if ((counter & (1 << j)) != 0)
					System.out.print(set[j] + " ");
			}
			System.out.println("");
		}
	}
}
