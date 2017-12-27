package stacksandqueues;

import java.util.ArrayList;

public class Brackets {

	/*
	 * The solution of this problem involves using a stack. 
	 * The last bracket to be put into the list, must be the first to be taken out
	 * Last in => first out
	 */
	
	public static int solution(String s) {
		ArrayList<Character> stack = new ArrayList<Character>();
		char[] string = s.toCharArray();
		for (char c : string) {
			if (c == '[' || c == '{' || c == '(') {
				stack.add(c);
			} else if (stack.size() == 0) {
				return 0;
			} else {
				if (stack.get(stack.size() - 1) == getPair(c)) {
					stack.remove(stack.size() - 1);
				} else {
					return 0;
				}
			}
		}
		if (stack.size() == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	private static char getPair(char c) {
		switch (c) {
		case ')':
			return '(';
		case '}':
			return '{';
		case ']':
			return '[';
		default:
			break;
		}
		return ' ';
	}
}
