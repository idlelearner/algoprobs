package code.type;

import java.math.BigInteger;

public class GCDWithoutOps {
	public static void main(String[] args) {
		GCDWithoutOps g = new GCDWithoutOps();
		BigInteger x = new BigInteger("3");
		BigInteger y = new BigInteger("9");
		int a = 3, b = 9;
		System.out.println(g.GCD(a, b));
		System.out.println(g.GCD(x, y));
	}

	public static BigInteger TWO = new BigInteger("2");

	public boolean isOdd(BigInteger x) {
		return x.testBit(0);
	}

	public boolean isEven(BigInteger x) {
		return !isOdd(x);
	}

	public BigInteger GCD(BigInteger x, BigInteger y) {
		if (x.equals(BigInteger.ZERO))
			return y;
		else if (y.equals(BigInteger.ZERO))
			return x;
		else if (isEven(x) && isEven(y)) {
			x = x.shiftRight(1);
			y = y.shiftRight(1);
			return TWO.multiply(GCD(x, y));
		} else if (isOdd(x) && isEven(y))
			return GCD(x, y.shiftRight(1));
		else if (isEven(x) && isOdd(y))
			return GCD(x.shiftRight(1), y);
		else if (x.compareTo(y) <= 0)
			return GCD(x, y.subtract(x));
		else
			return GCD(y, x.subtract(y));
	}

	public int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}
}
