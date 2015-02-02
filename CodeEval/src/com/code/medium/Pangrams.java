package com.code.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Pangrams {
	public static void main(String[] args) throws IOException {
		Pangrams s = new Pangrams();
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.length() > 0) {
				// Process line of input Here
				System.out.println(s.getRemainingStr(line));
			}
		}

	}

	/**
	 * Remove the characters which are given as scrubbed strings.
	 * 
	 * @param s
	 * @return
	 */
	public String getRemainingStr(String s) {
		char c[] = new char[26];
		s = s.toLowerCase();
		char[] rep = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int j = 0;
		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), true);
		}
		for (int i = 0; i < rep.length; i++) {
			if (!map.containsKey(rep[i]))
				c[j++] = rep[i];
		}
		String r = new String(c).trim();
		if (r.equals(""))
			r = "NULL";
		return r;
	}
}
