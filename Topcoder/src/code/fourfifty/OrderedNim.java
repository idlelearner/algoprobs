package code.fourfifty;

public class OrderedNim {

	public static void main(String[] args) {
		OrderedNim o = new OrderedNim();
		//int a[] = { 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 2, 1 };
		int a[] = {10,9,8,7,6,5,4,3,2,1};
		System.out.println(o.winner(a));
	}

	public String winner(int a[]) {
		int f[] = new int[a.length];
		for (int i = 0; i < a.length; i++)
			f[i] = a[i];
		f[a.length - 1] = 1;
		for (int i = a.length - 2; i >= 0; i--) {
			if (f[i + 1] == 0)
				f[i] = 1;
			else {
				if (a[i] == 1)
					f[i] = 0;
				else
					f[i] = 1;
			}
		}
		return f[0] == 1 ? "Alice" : "Bob";
	}
}
