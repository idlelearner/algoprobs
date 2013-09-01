package code;

/**
 * Find majority element(number appearing more than n/2 times in array)
 * 
 * @author Dhass
 * 
 */
public class BoyceMooreVoting {

	public static void main(String[] args) {
		int a[] = { 1, 3, 3, 3, 2, 2 };
		BoyceMooreVoting b = new BoyceMooreVoting();
		System.out.println(b.findCandidate(a));
	}

	int findCandidate(int a[]) {
		int maxIndex = 0, count = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[maxIndex] == a[i])
				count++;
			else
				count--;

			if (count == 0) {
				maxIndex = i;
				count = 1;
			}
		}
		return a[maxIndex];
	}
}
