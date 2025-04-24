package org.example.maximumSumCircularSubarray;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int result = nums[0];

        for(int x = 0; x < nums.length; x++){
            if(x == 0 || (nums[x - 1] < 0 && nums[x] >= 0)){

                int maxEnding = nums[x];

                for(int j = 1 + x; j < nums.length + x; j++){
                    maxEnding = Math.max(maxEnding + nums[j % nums.length], nums[j % nums.length]);

                    result = Math.max(result, maxEnding);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {};
        System.out.println(solution.maxSubarraySumCircular(nums)); // Output: 3
    }
}
