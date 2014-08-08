package code.collections;

import java.util.TreeMap;

/**
 * TreeMap which sorts based on keys.
 * 
 * @author Dhass
 * 
 */
public class TreeMapEx {
	public static void main(String[] args) {
		TreeMap<String, Integer> tMap = new TreeMap<String, Integer>();
		tMap.put("abc", 2);
		tMap.put("cbc", 1);
		tMap.put("aac", 3);
		tMap.put("dbc", 2);
		for (String key : tMap.keySet())
			System.out.println("key : " + key + " Value: " + tMap.get(key));
	}
}
