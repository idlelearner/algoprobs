package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class myComp implements Comparator<Integer> {
	@Override
	public int compare(Integer i1, Integer i2) {
		String XY = i1.toString() + i2.toString();
		String YX = i2.toString() + i1.toString();
		//System.out.println(XY + " " + YX + " = " + XY.compareTo(YX));
		return XY.compareTo(YX) > 0 ? -1 : 1;
	}
}

public class MakeBiggestNoInArray {

	public static void main(String[] args) {
		int a[] = { 2, 45, 9, 78, 4 };
		List<Integer> aList = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++)
			aList.add(a[i]);
		Collections.sort(aList);
		System.out.println(Arrays.toString(aList.toArray()));
		Collections.sort(aList, new myComp());
		System.out.println(Arrays.toString(aList.toArray()));
	}

}


