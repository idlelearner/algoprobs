package code;

public class PowerFunction {

	public static void main(String[] args) {
		PowerFunction p = new PowerFunction();
		System.out.println(p.power(5, 3));
		System.out.println(1 / p.power(5, 9));
	}

	float power(float x, int y) {
		float temp;
		if (y == 0)
			return 1;
		temp = power(x, y / 2);
		if (y % 2 == 0)
			return temp * temp;
		else {
			if (y > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}
}
