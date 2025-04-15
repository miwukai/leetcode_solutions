package org.example.movementOfRobots;

import java.util.Arrays;

public class Solution {
    public int sumDistance(int[] nums, String s, int d) {

//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = nums[i] + (s.charAt(i) == 'L' ? -d : d);
//        }
//
//        Arrays.sort(nums);
//
//        long output = 0;
//
//        int n = nums.length - 1;
//
//        for (int i = 1; i < nums.length; i++) {
//            output = (output + (nums[i] - nums[i - 1]) * i * (n - i + 1)) % 1000000007;
//        }
//
//        return (int)output;

        long numsInLong[] = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numsInLong[i] = ((long)nums[i] + (s.charAt(i) == 'L' ? -d : d));
        }

        Arrays.sort(numsInLong);

        long output = 0;

        int n = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            output = (output + (long) numsInLong[i] * (2 * i - n)) % 1000000007;
        }

        return (int) output;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2000000000,-2000000000};
        String s = "RL";
        int d = 1000000000;
        System.out.println(solution.sumDistance(nums, s, d));
    }
}
