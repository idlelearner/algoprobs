package code.advancedds;

import java.util.Random;

public class KDTree {
	int compare(Point p1, Point p2, boolean divX) {
		if (divX)
			return (p1.x < p2.x) ? -1 : ((p1.x > p2.x) ? 1 : 0);
		else
			return (p1.y < p2.y) ? -1 : ((p1.y > p2.y) ? 1 : 0);
	}

	int partition(Point p[], int s, int e, int pivot, boolean divX) {
		Point t = p[s];
		p[s] = p[pivot];
		p[pivot] = t;

		pivot = s;

		while (s <= e) {
			while (s <= e && compare(p[s], p[pivot], divX) <= 0)
				s++;
			while (s <= e && compare(p[e], p[pivot], divX) >= 0)
				e--;
			if (s < e) {
				t = p[s];
				p[s] = p[e];
				p[e] = t;
			}

		}
		t = p[pivot];
		p[pivot] = p[e];
		p[e] = t;
		return s - 1;
	}

	// amortized O(n) method to find the nth element(0-based) in an array
	int nthElement(Point[] p, int s, int e, int n, boolean divX) {
		if (s == e)
			return s;
		// get a random index between [s,e] inclusive
		Random r = new Random();
		int RND = s + r.nextInt() % (e - s + 1);
		int pivot = partition(p, s, e, RND, divX);

		int k = pivot - s;
		if (n < k) {
			return nthElement(p, s, pivot - 1, n, divX); // go left
		}
		if (n > k) {
			return nthElement(p, pivot + 1, e, n - k - 1, divX); // go right
		}
		return pivot;
	}

	// build the KD tree
	// third parameter is for the division dimension
	void build(Point p[], int s, int e, boolean divX) {
		if (s >= e)
			return;

		// we will try to find the median of p[s..e]
		int mid = (e + s) / 2;
		int n = mid - s; // we are interested in the median
		nthElement(p, s, e, n, divX);

		build(p, s, mid - 1, !divX);
		build(p, mid + 1, e, !divX);
	}

	long bestDist = 1 << 30;
	int bestNode = -1;

	void findNearestNeighbour(Point p[], int s, int e, int x, int y,
			boolean divX) {
		if (s >= e)
			return;

		int mid = (e + s) / 2;

		Point midp = p[mid];
		long dx = x - midp.x;
		long dy = y - midp.y;

		long d = dx * dx + dy * dy;
		if (bestDist > d) {
			bestDist = d;
			bestNode = mid;
		}

		int s1 = s, e1 = mid - 1;
		int s2 = mid + 1, e2 = e;
		long delta = divX ? dx : dy;
		if (delta > 0) {
			s1 = s1 + s2 - (s2 = s1);
			e1 = e1 + e2 - (e2 = e1);
		}

		findNearestNeighbour(p, s1, e1, x, y, !divX);
		long delta2 = delta * delta;
		if (delta2 < bestDist)
			findNearestNeighbour(p, s2, e2, x, y, !divX);

	}

}

class Point {
	int x;
	int y;
}