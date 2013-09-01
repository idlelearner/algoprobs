package code;

public class CharCount {
	public static void main(String[] args) {
		int c[] = new int[256];
		//byte b[] = new byte[5];
		char ca='a';
		for(int i=ca;i<ca+26;i++)
			c[i] = i;
		for(int i=ca;i<ca+26;i++)
			System.out.println(c[i]);
	}

}
