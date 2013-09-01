package code.bitmanipulation;

public class PowerOfTwo {
	public static void main(String[] args) {
		int n = 128;
		// Gives 0 if n is power of two
		System.out.println(n & (n - 1));
	}
}
