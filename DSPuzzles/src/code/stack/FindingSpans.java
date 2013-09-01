package code.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Finding increasing values in O(n) using stacks 
 * src : pg: 95 
 * @author Dhass
 * 
 */
public class FindingSpans {
	public static void main(String[] args) {
		int a[] = { 6, 3, 4, 5, 2, 4 };
		FindingSpans f = new FindingSpans();
		System.out.println(Arrays.toString(f.findingSpans(a)));
	}

	int[] findingSpans(int[] inputArray) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] spans = new int[inputArray.length];
		int p = 0;
		for (int i = 0; i < inputArray.length; i++) {
			//pop all the elmts less than current elmt from stack
			//Only peak points will be present in the stack.
			while (!stack.isEmpty() && inputArray[i] > inputArray[stack.peek()])
				stack.pop();
			if (stack.isEmpty())
				p = -1;
			else
				p = stack.peek();
			spans[i] = i - p;
			stack.push(i);
		}
		return spans;
	}
}
