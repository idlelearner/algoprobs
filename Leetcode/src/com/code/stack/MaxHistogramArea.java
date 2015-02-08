package com.code.stack;

import java.util.Stack;

/**
 * Max area under a histogram using stacks.
 * 
 * @author thirunavukarasu
 *
 */
public class MaxHistogramArea {
	public static void main(String[] args) {
		MaxHistogramArea m = new MaxHistogramArea();
		int[] height = { 2, 1, 5, 6, 2, 3 };
		System.out.println(m.largestRectangleArea(height));
	}

	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = Integer.MIN_VALUE;
		stack.push(-1);
		for (int i = 0; i < height.length; i++) {
			while (stack.peek() != -1) {
				if (height[stack.peek()] > height[i]) {
					int top = stack.pop();
					max = Math.max(max, height[top] * (i - 1 - stack.peek()));
				} else
					break;
			}
			stack.push(i);
		}
		while (stack.peek() != -1) {
			int top = stack.pop();
			max = Math.max(max, height[top]
					* (height.length - 1 - stack.peek()));
		}
		return max;
	}
}
