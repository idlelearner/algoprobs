package code.puzzles;

public class SwapValues {
	public static void main(String[] args) {
		int A = 10, B = 20;
		A = A + B - (B = A);
		System.out.println("A:" + A);
		System.out.println("B:" + B);
	}
}
