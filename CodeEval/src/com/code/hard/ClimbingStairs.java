package com.code.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ClimbingStairs {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			// Process line of input Here
			int n = Integer.parseInt(line);
		}
	}

	public int getNumberOfWays(int n, int c[], int i) {
		if (i <= 1)
			return c[n];
		else if (c[i] != 0)
			return c[i];
		else {
			// c[i] = getNumberOfWays(n,c,i)
		}
		return 0;
	}
}
