package code.recursion;

/**
 * Source : DS Made easy in Java
 * @author Dhass
 *
 */
public class TowersOfHanoi {

	public static void main(String[] args) {
		TowersOfHanoi t = new TowersOfHanoi();
		t.towersOfHanoi(4, 'A', 'C', 'B');
	}

	//TODO: Can implement for array of discs in Peg
	
	void towersOfHanoi(int n, char fromPeg, char toPeg, char auxPeg) {
		if (n == 1) {
			System.out.println("Move disc 1 from " + fromPeg + " to " + toPeg);
			return;
		}
		towersOfHanoi(n - 1, fromPeg, auxPeg, toPeg);
		System.out.println("Move disc " + n + " from " + fromPeg + " to "
				+ toPeg);
		towersOfHanoi(n - 1, auxPeg, toPeg, fromPeg);
	}
}
