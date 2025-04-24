package org.example.maximumSumCircularSubarray;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int total = 0;
        int maxEnding = 0;
        int maxSum = nums[0];
        int minEnding = 0;
        int minSum = nums[0];

        for(int x = 0; x < nums.length; x++){
            maxEnding = Math.max(maxEnding + nums[x], nums[x]);
            maxSum = Math.max(maxEnding, maxSum);
            minEnding = Math.min(minEnding + nums[x], nums[x]);
            minSum = Math.min(minEnding, minSum);
            total += nums[x];
        }

        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {};
        System.out.println(solution.maxSubarraySumCircular(nums));
    }
}
