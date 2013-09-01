package code.collections;

import java.util.LinkedList;
import java.util.ListIterator;
import static java.util.Arrays.asList;

/**
 * Eg for add in listIterator
 * @author Dhass
 *
 */
public class ListIteratorAdd {

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		l.add(20);
		ListIteratorAdd a = new ListIteratorAdd();
		a.addIntoCollection(new LinkedList<>(asList(10, 20, 50, 60)));
	}

	public void addIntoCollection(LinkedList<Integer> marks) {
		for (ListIterator<Integer> iterator = marks.listIterator(); iterator
				.hasNext();) {
			Integer mark = iterator.next();
			if (mark < 40)
				iterator.add(mark);
		}
		System.out.println("marks = " + marks);
	}
}
