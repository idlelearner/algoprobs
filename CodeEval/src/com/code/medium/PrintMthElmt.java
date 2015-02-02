package com.code.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/10/
 * @author thiru022
 *
 */
public class PrintMthElmt {
	public static void main(String[] args) throws IOException {
		PrintMthElmt s = new PrintMthElmt();
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.length() > 0) {
				// Process line of input Here
				s.printMthElmt(line);

			}
		}

	}

	/**
	 * print the mth elmt from last
	 * @param s
	 */
	public void printMthElmt(String s) {
		String cs[] = s.split(" ");
		int l = cs.length;
		int v = Integer.parseInt(cs[l - 1]);
		if ((l - v - 1) >= 0)
			System.out.println(cs[l - v - 1]);
	}
}
