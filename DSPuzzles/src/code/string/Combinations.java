package code.string;


/**
 * Combinations of all characters in a string
 * 
 * @author Dhass
 * 
 */
public class Combinations {
	int count;

	public static void main(String[] args) {
		Combinations c = new Combinations();
		c.count = 0;
		c.combinations2("ABCD");
		System.out.println(c.count);
	}

	public void combinations2(String s) {
		combinations2("", s);
	}

	public void combinations2(String prefix, String s) {
		System.out.println(prefix);
		count++;
		for (int i = 0; i < s.length(); i++) {
			combinations2(prefix + s.charAt(i), s.substring(i + 1));
		}
	}
}
