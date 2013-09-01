package code.type;

public class PowerSet {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		PowerSet p = new PowerSet();
		p.powerSet(a);
	}

	public void powerSet(int a[]) {
		for (int i = 1; i < 1 << a.length; i++) {
			int j = 0;
			// TODO: think something without traversing all the bits in number
			// while (i != 0) {
			// i = 1 << j;
			// System.out.print(a[t]);
			// }
			System.out.println();
		}
	}
}
