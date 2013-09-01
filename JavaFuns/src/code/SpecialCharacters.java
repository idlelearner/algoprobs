package code;

import java.util.HashMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class SpecialCharacters {
	public static void main(String[] args) {
		System.out.println("\uff4f");
		for (int i = Character.MIN_CODE_POINT; i <= Character.MAX_CODE_POINT; i++)
			if (Character.isJavaIdentifierStart(i)
					&& !Character.isAlphabetic(i))
				System.out.println(i + " : " + (char) i);
		
//		TreeMap<Integer,Integer> t = new TreeMap<Integer,Integer>();
//		SortedMap<Integer,Integer> s = new SortedMap<Integer,Integer>();
//		NavigableSet<Integer> nn = new NavigableSet<Integer>();
//		ConcurrentSkipListSet<Integer> c = new ConcurrentSkipListSet<>(); 
//		
	}
	
	
}
