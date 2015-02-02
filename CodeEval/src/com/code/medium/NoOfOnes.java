package com.code.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/16/
 * 
 * @author thiru022
 *
 */
public class NoOfOnes {
	public static void main(String[] args) throws IOException {
		NoOfOnes s = new NoOfOnes();
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.length() > 0) {
				// Process line of input Here
				System.out.println(s.noOfOnes(Integer.parseInt(line)));
			}
		}
	}

	/**
	 * Count the number of ones
	 * 
	 * @param n
	 * @return
	 */
	public int noOfOnes(int n) {
		int c = 0;
		while (n != 0) {
			c++;
			n = n & (n - 1);
		}
		return c;
	}

}
