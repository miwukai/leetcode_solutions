package org.example.basicCalculator;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        char[] tokens = s.toCharArray();

        int result = 0;

        int sign = 1;

        int tempVal = 0;

        Stack<Character> st = new Stack<Character>();

        for(char t : tokens){
            if(t == '+' || t == '-'){
                result = result + sign * (st.isEmpty() || st.pop() == '+' ? 1 : -1) * tempVal;
                tempVal = 0;
                st.push(t);
            } else if (t == '('){
                if(!st.isEmpty() && st.peek() == '-'){
                    sign = sign * -1;
                }
                st.push('+');
            } else if(t == ')'){
                result = result + sign * (st.isEmpty() || st.pop() == '+' ? 1 : -1) * tempVal;
                tempVal = 0;
                if(!st.isEmpty() && st.peek() == '-'){
                    sign = sign * -1;
                }
            } else if (t == ' '){
                continue;
            } else {
                tempVal = tempVal * 10 + (int)(t - '0');
            }
        }

        result = result + sign * (st.isEmpty() || st.pop() == '+' ? 1 : -1) * tempVal;

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))"));
    }
}
