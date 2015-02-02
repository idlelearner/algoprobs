package com.code.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.codeeval.com/open_challenges/13
 * 
 * @author thiru022
 *
 */
public class ScrubStrings {
	public static void main(String[] args) throws IOException {
		ScrubStrings s = new ScrubStrings();
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.length() > 0) {
				// Process line of input Here
				System.out.println(s.getScrubbedStr(line));
			}
		}

	}

	/**
	 * Remove the characters which are given as scrubbed strings.
	 * 
	 * @param s
	 * @return
	 */
	public String getScrubbedStr(String s) {
		String src = s.split(",")[0];
		char c[] = new char[src.length()];
		String rep = s.split(",")[1].trim();
		int j = 0;
		for (int i = 0; i < src.length(); i++) {
			if (!rep.contains("" + src.charAt(i) + "")) {
				c[j++] = src.charAt(i);
			}
		}
		return new String(c).trim();
	}
}
