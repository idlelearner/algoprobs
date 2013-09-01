package code;

public class NoOfWaysDeneminationSingleSelection {
	boolean v[];

	public static void main(String[] args) {
		NoOfWaysDeneminationSingleSelection n = new NoOfWaysDeneminationSingleSelection();
		int a[] = { 1, 2, 3, 4, 5 };
		n.v = new boolean[a.length];
		System.out.println(n.noOfWays(a, 0, 6));
	}

	public int noOfWays(int a[], int i, int amt) {
		int n = 0;
		if (amt == 0)
			return 1;
		if (i == a.length)
			return 0;
		n += noOfWays(a, i + 1, amt);
		if (!v[i]) {
			v[i] = true;
			int val = noOfWays(a, i + 1, amt - a[i]);
			if (val > 0) {
				n += val;
			} else
				v[i] = false;
		}
		return n;
	}
}
