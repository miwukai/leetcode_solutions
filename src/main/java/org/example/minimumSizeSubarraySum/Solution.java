package org.example.minimumSizeSubarraySum;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 1;
        int tempSum = nums[left] + nums[right];
        int result = Integer.MAX_VALUE;

        while(left < right && right < nums.length){
            if(nums[left] >= target || nums[right] >= target){
                return 1;
            }

            if (tempSum >= target){
                result = Math.min(result, right - left + 1);
                tempSum -= nums[left];
                left++;
            } else if(tempSum < target){
                right++;
                if(right < nums.length){
                    tempSum += nums[right];
                }
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(solution.minSubArrayLen(target, nums));
    }
}
