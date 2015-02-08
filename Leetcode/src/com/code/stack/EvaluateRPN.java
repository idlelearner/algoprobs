package com.code.stack;
import java.util.Stack;

public class EvaluateRPN {
	public static void main(String[] args) {
		EvaluateRPN e = new EvaluateRPN();
		String a[] = { "0", "3", "/" };
		System.out.println(e.evalRPN(a));
	}

	public int evalRPN(String[] tokens) {
		if (tokens.length == 1)
			return Integer.parseInt(tokens[0]);
		String codes = "+-*/";
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (codes.contains(tokens[i])) {
				int b = s.pop();
				int a = s.pop();
				switch (tokens[i]) {
				case "+":
					s.push(a + b);
					break;
				case "-":
					s.push(a - b);
					break;
				case "*":
					s.push(a * b);
					break;
				case "/":
					s.push(a / b);
					break;
				}
			}
			else
				s.push(Integer.parseInt(tokens[i]));
		}
		return s.pop();
	}
}
