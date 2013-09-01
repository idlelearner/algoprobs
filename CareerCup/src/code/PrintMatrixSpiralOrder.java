package code;

public class PrintMatrixSpiralOrder {
	public static void main(String[] args) {
		PrintMatrixSpiralOrder p = new PrintMatrixSpiralOrder();
		int a[][] = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		p.printSpiralOrder(a);
	}

	public void printSpiralOrder(int a[][]) {
		int m = a.length,n = a[0].length;
		int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;
		while (rowStart <= rowEnd && colStart <= colEnd) {
			int i = rowStart, j = colStart;
			for (j = colStart; j <= colEnd; j++)
				System.out.print(a[i][j] + " ");
			for (i = rowStart + 1, j--; i <= rowEnd; i++)
				System.out.print(a[i][j] + " ");
			for (j = colEnd - 1, i--; j >= colStart; j--)
				System.out.print(a[i][j] + " ");
			for (i = rowEnd - 1, j++; i > rowStart; i--)
				System.out.print(a[i][j] + " ");
			rowStart++;rowEnd--;colStart++;colEnd--;
		}
	}
}
