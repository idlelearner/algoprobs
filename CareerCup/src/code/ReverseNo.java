package code;

public class ReverseNo {
	public static int intReverse(int n, int sum) {
		if (n == 0)
			return sum;
		else
			return intReverse(n / 10, sum * 10 + n % 10);
	}

	public static void main(String[] args) {
		System.out.println(intReverse(12345, 0));
	}

}
