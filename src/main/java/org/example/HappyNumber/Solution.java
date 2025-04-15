package org.example.HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> exist = new HashSet();

        while(!exist.contains(n)){
            exist.add(n);
            n = cal(n);
            if(n == 1){
                return true;
            }
        }

        return false;
    }

    private int cal(int x){
        int result = 0;
        while(x > 0){
                int y = x % 10;
                result += Math.pow(y,2);
                x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isHappy(2));
    }
}
