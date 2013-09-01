package code.string;

/**
 * Permutations of chars in the given String
 * 
 * @author Dhass
 * 
 */
public class Permutation {
	int count;

	public static void main(String[] args) {

		Permutation p = new Permutation();
		p.permuationsInOrder("AB");
		p.count = 0;
		//p.permuations("0123456789", 4);
		System.out.println("----------------------------------------");
		System.out.println(p.count);
		// p.permutationsNotInOrder("ABC");
	}

	// Clearly working
	// Complexity O(n!)
	public void permuationsInOrder(String s) {
		permutationsInorder("", s);
	}

	public void permutationsInorder(String prefix, String s) {
		int len = s.length();
		if (len == 0)
			System.out.println(prefix);
		for (int i = 0; i < s.length(); i++)
			permutationsInorder(prefix + s.charAt(i),
					s.substring(0, i) + s.substring(i + 1, len));
	}

	public void permuations(String s, int size) {
		permutations("", s, size);
	}

	public void permutations(String prefix, String s, int size) {
		int len = s.length();
		if (prefix.length() == size) {
			System.out.println(prefix);
			count++;
		}
		for (int i = 0; i < s.length(); i++)
			permutations(prefix + s.charAt(i),
					s.substring(0, i) + s.substring(i + 1, len), size);
	}
}
