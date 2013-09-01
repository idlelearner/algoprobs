package code.backtracking;

public class NineDigitNumber {
	public static boolean findTheNum(long num, int[] digits, int index) {
		if (index == digits.length - 1) {
			num = num * 10 + digits[index];
			System.out.println(num);

			return true;
		}

		for (int i = index; i < digits.length; i = i + 2) {
			swap(digits, index, i);
			long nextNum = num * 10 + digits[index];
			if (nextNum % (index + 1) == 0) {

				if (findTheNum(nextNum, digits, index + 1)) {
					return true;
				}
			}
			swap(digits, index, i);
		}

		return false;
	}

	private static void swap(int[] digits, int i, int j) {
		int temp = digits[i];
		digits[i] = digits[j];
		digits[j] = temp;
	}

	public static void main(String[] args) {
		int[] digits = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		findTheNum(0, digits, 0);
	}
}