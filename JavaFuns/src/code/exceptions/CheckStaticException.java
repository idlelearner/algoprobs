package code.exceptions;

public class CheckStaticException {
	public static void main(String[] args) {
		CheckStaticException c = new CheckStaticException();
		c.checkException();
		checkStaticException();
	}

	public static void checkStaticException() {
		int a[] = new int[1];
		a[2] = 0;
	}
	
	private void checkException(){
		int a[] = new int[1];
		a[2] = 0;
	}
}
