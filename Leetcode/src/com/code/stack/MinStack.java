package com.code.stack;

/**
 * Dynamically resizing stack with getMin in O(1)
 * @author dhass
 *
 */
class MinStack {
	int[] val;
	int[] minList;
	int top = -1;

	public MinStack() {
		val = new int[16];
		minList = new int[16];
	}

	public static void main(String[] args) {
		MinStack m = new MinStack();
		m.push(-2);
		m.push(0);
		m.push(-1);
	}

	public void push(int x) {

		if (top >= val.length - 1)
			resize(val.length * 2);

		if (top == -1) {
			top++;
			minList[top] = x;
			val[top] = x;
		} else {
			int t = getMin();
			top++;
			val[top] = x;
			if (t < x)
				minList[top] = t;
			else
				minList[top] = x;
		}
	}

	public void pop() {
		if (top != -1)
			top--;
	}

	public int top() {
		return val[top];
	}

	public int getMin() {
		return minList[top];
	}

	public void resize(int size) {
		int tval[] = new int[size];
		int mval[] = new int[size];
		for (int i = 0; i < val.length; i++) {
			tval[i] = val[i];
			mval[i] = minList[i];
		}

		val = tval;
		minList = mval;
	}
}
