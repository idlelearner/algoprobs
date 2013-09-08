package code;

/**
 * Divide the set into subsets of equal sum
 * @author Dhass
 *
 */
public class FindSubsetSumZero {
	public static void main(String[] args) {
		int a[] = { 2, 5, 6, 3, 4 };
		FindSubsetSumZero f = new FindSubsetSumZero();
		int s = f.findSum(a);
		if (s % 2 == 1)
			System.out
					.println("Set cannot be divided into two sets with  equal value");
		else {
			int in[] = new int[a.length];
			f.getSubSetSum(a, in, 0, 0, 0, s / 2);
		}
	}

	public void getSubSetSum(int a[], int in[], int i, int j, int s, int ts) {
		if (ts == s) {
			printTwoSets(a, in, j - 1);
			return;
		}
		if (s > ts || i >= a.length)
			return;

		in[j] = i;
		s = s + a[i];
		j++;
		getSubSetSum(a, in, i + 1, j, s, ts);
		j--;
		s -= a[i];
	}

	public void printTwoSets(int a[], int in[], int n) {
		boolean v[] = new boolean[a.length];
		for (int i = 0; i <= n; i++) {
			System.out.print(a[in[i]] + " ");
			v[in[i]] = true;
		}
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			if (!v[i])
				System.out.print(a[i] + " ");
		}

	}

	int findSum(int a[]) {
		int s = 0;
		for (int i : a)
			s += i;
		return s;
	}
}
