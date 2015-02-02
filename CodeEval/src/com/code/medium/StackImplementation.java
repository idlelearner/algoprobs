package com.code.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StackImplementation {
	public static void main(String[] args) throws IOException {
		StackImplementation s = new StackImplementation();
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;

		while ((line = in.readLine()) != null) {
			if (line.length() > 0) {
				// Process line of input Here
				int a[] = s.getNosOfString(line);
				for (int j = a.length - 1; j > 0; j = j - 2)
					System.out.print(a[j] + " ");
				System.out.println("");
			}
		}

	}

	/**
	 * Gets the list of integers in a String
	 * 
	 * @param s
	 * @param a
	 * @return
	 */
	public int[] getNosOfString(String s) {
		String numberStr = "1234567890";
		char c[] = s.toCharArray();
		int a[] = new int[c.length];
		int j = 0;
		int n = 0;
		int k = 0;
		boolean nve = false;
		for (int i = 0; i < c.length; i++) {
			if (numberStr.contains("" + c[i] + "")) {
				n = (int) Math.pow(10, k) * n + c[i] - '0';
				k++;
			} else if (c[i] == '-')
				nve = true;
			else {
				a[j++] = (nve ? -1 * n : n);
				nve = false;
				n = 0;
				k = 0;
			}

		}
		if (k > 0)
			a[j++] = n;
		int b[] = new int[j];
		for (int i = 0; i < j; i++)
			b[i] = a[i];
		return b;
	}
}
