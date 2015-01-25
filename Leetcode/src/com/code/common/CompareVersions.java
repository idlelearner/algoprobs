package com.code.common;

/**
 * Compare the given string versions
 * 
 * @author dhass
 *
 */
public class CompareVersions {
	public static void main(String[] args) {
		CompareVersions c = new CompareVersions();
		System.out.println(c.compareVersion("1.0", "1.1"));
	}

	public int compareVersion(String version1, String version2) {
		if (version1.length() == 1 && version2.length() == 1)
			return Integer.compare(Integer.parseInt(version1),
					Integer.parseInt(version2));
		String s1[] = version1.split("\\.");
		String s2[] = version2.split("\\.");
		int i = 0, j = 0;
		while (i < s1.length || j < s2.length) {
			int a = i < s1.length ? Integer.parseInt(s1[i]) : 0;
			int b = j < s2.length ? Integer.parseInt(s2[j]) : 0;
			if (a > b)
				return 1;
			else if (a < b)
				return -1;
			i++;
			j++;
		}
		return 0;
	}
}
