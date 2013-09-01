package code;

public class ReverseString {
	public static void main(String[] args) {
		ReverseString r = new ReverseString();
		String a = "ABCDEFG";
		r.reverseString(a, "");
		System.out.println(r.reverse(a));
	}

	public void reverseString(String a, String rev) {
		if (a.length() == 0)
			System.out.println(rev);
		else {
			reverseString(a.substring(0, a.length() - 1),
					rev + a.charAt(a.length() - 1));
		}
	}

	public String reverse(String s) {
		if (s.length() <= 1 || null == s) {
			return s;
		}
		return reverse(s.substring(1, s.length())) + s.charAt(0);
	}
}
