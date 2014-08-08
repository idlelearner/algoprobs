package code;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BigDecimalEx {
	public static void main(String[] args) {
		BigDecimal b = new BigDecimal("34.12312331");
		b.setScale(4, 4);
		System.out.print(b.toPlainString());

		ArrayList<Integer> a = new ArrayList<>(1);
		a.add(1);
		a.add(2);
		a.add(3);

		for (int i : a)
			System.out.println(i);

		// HashMap<MutableKey,Integer> h = new HashMap<>();
	}
}
