package code.type;

public class ExcelColIDToNum {
	public static void main(String[] args) {
		ExcelColIDToNum e = new ExcelColIDToNum();
		System.out.println(e.ssDecodeColID("ZA"));
	}

	public int ssDecodeColID(String val) {
		int n = 0;
		for (char c : val.toCharArray())
			n = n * 26 + c - 'A' + 1;
		return n;
	}

}
