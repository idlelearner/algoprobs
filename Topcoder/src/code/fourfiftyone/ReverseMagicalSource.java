package code.fourfiftyone;

public class ReverseMagicalSource {
	public static void main(String[] args) {
		ReverseMagicalSource r = new ReverseMagicalSource();
		// System.out.println(r.find(27373, 574062));
		// 3038403
		System.out.println(r.find(333, 36963));
	}

	public int find(int source, int A) {
		int s = source;
		int p = source;
		int i = 1;
		while (s <= A) {
			p = source * (int) Math.pow(10, i);
			s = s + p;
			i++;
		}
		return s;
	}
}
