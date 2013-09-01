package code;

public class NoOfWaysToFormNoFromArray {

	public static void main(String[] args) {
		int a[] = { 2, 4, 6, 8 };
		NoOfWaysToFormNoFromArray n = new NoOfWaysToFormNoFromArray();
		System.out.println(n.getNoOfWays(a, 0, 12));
	}

	public int getNoOfWays(int[] array, int index, int value) {
		if (index == array.length && value != 0)
			return 0;
		else if (value == 0)
			return 1;
		// int count = 0;
		// if (value == 0)
		// count++;
		return getNoOfWays(array, index + 1, value)
				+ getNoOfWays(array, index + 1, value - array[index])
				+ getNoOfWays(array, index + 1, value + array[index]);
	}

}
