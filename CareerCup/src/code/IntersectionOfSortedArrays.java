package code;

public class IntersectionOfSortedArrays {
	public static void main(String[] args) {
		int a[] = { 1, 1, 1, 1, 9, 12 };
		int b[] = { 1, 2, 3, 5 };
		IntersectionOfSortedArrays i = new IntersectionOfSortedArrays();
		i.intersectionOfSortedArrays(a, b);
	}

	public void intersectionOfSortedArrays(int a[], int b[]) {
		int al = a.length, bl = b.length;
		int c[] = new int[al + bl];
		int i = 0, j = 0, k = 0;

		while (i <= al - 1 && j <= bl - 1) {
			if (i < al && j < bl) {
				if (a[i] == b[j]) {
					if (k == 0 || c[k - 1] != a[i]) {
						c[k] = a[i];
						k++;
						i++;
						j++;
					} else {
						i++;
						j++;
					}
				} else if (a[i] < b[j]) {
					i++;
				} else
					j++;
			}
		}
		// Output
		for (int n = 0; n < k; n++)
			System.out.print(a[n] + " ");
	}

}
