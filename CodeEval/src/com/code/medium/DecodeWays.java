package com.code.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DecodeWays {
	public static void main(String[] args) throws IOException {
		DecodeWays s = new DecodeWays();
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.length() > 0) {
				// Process line of input Here
				System.out.println(s.numDecodings(line));
			}
		}

	}

	public int numDecodings(String s) {
		int m[] = new int[s.length() + 1];
		int n = s.length();
		if (n == 0)
			return 0;
		m[n] = 1;
		m[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
		for (int i = n - 2; i >= 0; i--) {
			if (s.charAt(i) == '0')
				continue;
			if (Integer.parseInt(s.substring(i, i + 2)) <= 26)
				m[i] = m[i + 1] + m[i + 2];
			else
				m[i] = m[i + 1];
		}
		return m[0];
	}
}
