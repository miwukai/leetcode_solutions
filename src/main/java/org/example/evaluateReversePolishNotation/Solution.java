package org.example.evaluateReversePolishNotation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1){
            return Integer.valueOf(tokens[0]);
        }

        Stack<String> st = new Stack();

        Integer result = null;

        for(String s : tokens){
            if(s.equals("+")){
                result = Integer.valueOf(st.pop());
                result = Integer.valueOf(st.pop()) + result;
                st.push(result + "");
            } else if(s.equals("-")){
                result = Integer.valueOf(st.pop());
                result = Integer.valueOf(st.pop()) - result;
                st.push(result + "");
            } else if(s.equals("*")){
                    result = Integer.valueOf(st.pop());
                result = Integer.valueOf(st.pop()) * result;
                st.push(result + "");
            } else if(s.equals("/")){
                    result = Integer.valueOf(st.pop());
                result = Integer.valueOf(st.pop()) / result;
                st.push(result + "");
            } else {
                st.push(s);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"3","11","+","5","-"}));
    }
}
