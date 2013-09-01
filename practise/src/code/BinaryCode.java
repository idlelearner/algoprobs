package code;

public class BinaryCode {
	public static void main(String[] args) {
		Integer i = 1000000000;
		String b = i.toBinaryString(i);
		System.out.println(b);
		b = new StringBuilder(b).reverse().toString();
		System.out.println(b);
		System.out.println(Integer.parseInt(b, 2));
	}
}
