package code;

import java.util.ArrayList;
import java.util.Arrays;

public class FinalValues {
	final int a;
	final int b = 3;
	final ArrayList<String> s = new ArrayList<String>(Arrays.asList("a", "b"));

	public FinalValues(int a) {
		this.a = a;
		s.add("c");
	}

	public static void main(String[] args) {

	}
}
