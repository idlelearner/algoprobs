package code.selectionalgo;

public class FindMedian {

	public static void main(String[] args) {
		int A[] = { 2, 7, 1, 9, 12, 3 };
		int p = 0, r = A.length - 1;
		FindMedian m = new FindMedian();
		if (A.length % 2 == 1) {
			// Odd length
			int medPos = p + (r - p) / 2;
			int medianElmt = m.median(A, p, r, medPos);
			System.out.println(medianElmt);
		} else {
			// Even length medians
			int m1 = (A.length + 1) / 2;
			int m2 = m1++;
			int medianElmt1 = m.median(A, p, r, m1-1);
			int medianElmt2 = m.median(A, p, r, m2-1);
			double medianElmt = (medianElmt1 + medianElmt2) / 2;
			System.out.println(medianElmt);
		}
	}

	// Function to find the elmt at the medPos
	// Can be used to find kth smallest and largest elmts
	int median(int A[], int p, int r, int medPos) {
		int piv = partition(A, p, r);
		if (medPos == piv)
			return A[medPos];
		else if (piv > medPos)
			return median(A, p, piv - 1, medPos);
		else
			return median(A, piv + 1, r, medPos);
	}

	// partition the array give the position for pivot elmt
	int partition(int A[], int p, int r) {
		// choosing the last elmt as pivot
		int x = A[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (A[j] <= x) {
				i++;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		int temp = A[i + 1];
		A[i + 1] = A[r];
		A[r] = temp;
		return i + 1;
	}
}
