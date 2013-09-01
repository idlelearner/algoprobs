package code;

/**
 * binary search using recursion
 * 
 * @author user
 * 
 */
public class BinarySearch {
	public static void main(String[] args) {
		int a[] = { 1, 3, 4, 5, 7 };
		BinarySearch b = new BinarySearch();
		System.out.println(b.bSearch(a, 5, 0, a.length - 1));
	}

	int bSearch(int a[], int elmt, int l, int r) {
		if (r < l)
			return 0;
		else {
			int mid = (l + r) / 2;
			if (a[mid] > elmt) {
				return bSearch(a, elmt, l, mid - 1);
			}
			if (a[mid] < elmt) {
				return bSearch(a, elmt, mid + 1, r);
			} else
				return mid;
		}
	}
}
