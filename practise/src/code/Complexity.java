package code;

/**
 * Test for complexity
 * Its sqrt of n
 * @author Dhass
 *
 */
public class Complexity {
	public static void main(String[] args) {
		int n = 100;
		int i = 1, s = 1;
		while (s <= n) {
			i++;
			s = s + i;
			System.out.print("1 ");
		}
	}
}
