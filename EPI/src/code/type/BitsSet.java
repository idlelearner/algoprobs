package code.type;

public class BitsSet {
	public static void main(String[] args) {
		int x = 234, res = 0;
		while (x != 0) {
			res++;
			x = x & (x - 1);
			System.out.println(x);
		}
		System.out.println(res);
	}
}
