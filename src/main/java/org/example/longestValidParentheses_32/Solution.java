package longestValidParentheses_32;

import java.util.Stack;

public class Solution {

	// ( ( ) ( ( ( ) ) ) )
	// 0 0 2 0 0 0 2 4 8 10

	// ) ( ( ( ( ( ( ) ( ) ) ( ) ( ) ) ) ( ) ( ( ) ) ) (
	// 0 0 0 0 0 0 0 2 0 4 6 0 8 0 10 12 14 0 16 0 0 2 20 22 0

	public int longestValidParentheses(String s) {

		int result = 0;

		if (s.length() == 0) {
			return result;
		}

		char[] charArray = s.toCharArray();

		int[] lengthArray = new int[charArray.length];

		int templength = 0;

		Stack pStack = new Stack();

		for (int i = 0; i < charArray.length; i++) {

			if (charArray[i] == '(') {
				pStack.add(charArray[i]);

				templength = 0;
			} else {
				if (pStack.size() > 0) {
					pStack.pop();

					templength += 2;

					lengthArray[i] = 2 + lengthArray[i - 1] + (i >= templength ? lengthArray[i - templength] : 0);

					if (pStack.size() == 0) {
						templength = 0;
					}
				}
			}
			result = Math.max(result, lengthArray[i]);
		}

		return result;
	}

	public static void main(String[] args) {
		String s = ")(((((()())()()))()(()))(";
//				"(()()";
//				"(()((())))";

		Solution so = new Solution();

		System.out.println(so.longestValidParentheses(s));
	}
}
