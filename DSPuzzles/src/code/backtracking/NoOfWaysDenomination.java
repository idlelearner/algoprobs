package code.backtracking;

//http://www.careercup.com/question?id=16796662
public class NoOfWaysDenomination {
	int ways;

	public static void main(String[] args) {
		NoOfWaysDenomination n = new NoOfWaysDenomination();
		int a[] = { 1, 5, 10, 25, 50 };
		int val = 100;
		int t[] = new int[a.length];
		n.count_ways(val, 0, a, t);
		System.out.println(n.ways);

	}

	public void count_ways(int N, int i, int arr[], int t[]) {
		if (N == 0) {
			ways = ways + 1;
			print(t, arr, i);
			return;
		}
		if (i == arr.length)
			return;

		for (int j = 0; j * arr[i] <= N; j++) {
			{
				t[i] = arr[i] * j;
				count_ways(N - t[i], i + 1, arr, t);
			}
		}
	}

	public void print(int t[], int a[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + "*" + t[i] / a[i] + " ");
		System.out.println();
	}
}
