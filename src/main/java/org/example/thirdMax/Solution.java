package org.example.thirdMax;

public class Solution {
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int count = 0;
        boolean flag = false;

        for (int num : nums) {
            if (num == Integer.MIN_VALUE && !flag) {
                count++;
                flag = true;
            }
            if (num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
                count++;
            } else if (num > secondMax && num < max) {
                thirdMax = secondMax;
                secondMax = num;
                count++;
            } else if (num > thirdMax && num < secondMax) {
                thirdMax = num;
                count++;
            }
        }
        if (count < 3) {
            return max;
        }
        return thirdMax;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,-2147483648};
        System.out.println(solution.thirdMax(nums));
    }
}
