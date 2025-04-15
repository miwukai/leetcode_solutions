package org.example.BulbSwitcher;

public class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
//        int count = 0;
//        for (int i = 1; i <= n; i++) {
//            int c = 0;
//            for (int j = 1; j <= i; j++) {
//                if (i % j == 0) {
//                    c++;
//                }
//            }
//            if (c % 2 != 0) {
//                count++;
//            }
//        }
//        return count;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.bulbSwitch(6));
    }
}
