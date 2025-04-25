package org.example.sqrt;

public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        int left = x / 2;
        int right = x;

        while ((long)left * (long)right > Integer.MAX_VALUE || x < left * left){
            right = left;
            left = left / 2;
        }

        int mid = (left + right) / 2;

        while(right - left > 1){
            if(x < (long)mid * (long)mid){
                right = mid;
                mid = (left + right) / 2;
            } else if (x > mid * mid){
                left = mid;
                mid = (left + right) / 2;
            } else {
                return mid;
            }
        }

        if(x < (long)right * (long)right){
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }
}
