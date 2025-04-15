package org.example.simplifyPath;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        String[] elements = path.split("/");

        StringBuilder sb = new StringBuilder();

        Stack<String> stack = new Stack();

        for (String element : elements) {
            if("..".equals(element)){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }

            if(element.length() > 0 && !".".equals(element)){
                stack.push(element);
            }
        }

        for(String element : stack){
            sb.append("/");
            sb.append(element);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/"));
    }
}
