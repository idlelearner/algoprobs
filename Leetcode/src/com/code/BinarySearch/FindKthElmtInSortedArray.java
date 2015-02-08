package com.code.BinarySearch;
public class FindKthElmtInSortedArray {
	/**
	 * Find Kth element in two sorted array.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FindKthElmtInSortedArray f = new FindKthElmtInSortedArray();
		int A[] = { 4 };
		int B[] = { 1, 2, 3 };

		System.out.println(f.findKthElmt(A, B, 1, 0, A.length - 1, 0,
				B.length - 1));
	}

	public int findKthElmt(int A[], int B[], int k, int aStart, int aEnd,
			int bStart, int bEnd) {
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
		if (aLen == 0)
			return B[k + bStart];
		if (bLen == 0)
			return A[k + aStart];
		if (k == 0) {
			if (A[aStart] < B[bStart])
				return A[aStart];
			else
				return B[bStart];
		}

		// int aMid = aStart + (aEnd - aStart) / 2;
		// int bMid = bStart + (bEnd - bStart) / 2;

		int aMid = aLen * k / (aLen + bLen); // a � s middle count
		int bMid = k - aMid - 1; // b�s middle count

		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;

		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}

		return findKthElmt(A, B, k, aStart, aEnd, bStart, bEnd);
	}
}
