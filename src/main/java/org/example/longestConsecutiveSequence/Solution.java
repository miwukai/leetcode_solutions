package org.example.longestConsecutiveSequence;

import java.util.*;
import java.util.function.IntFunction;

public class Solution {

        public int longestConsecutive(int[] nums) {
            if(nums.length == 0){
                return 0;
            }

            Arrays.sort(nums);

            int result = 1;
            int tempLength = 1;

            for(int i = 1; i<nums.length; i++){
                if(nums[i] == nums[i-1] + 1){
                    tempLength++;
                } else {
                    result = Math.max(result,tempLength);
                    tempLength = 1;
                }
            }

            return Math.max(result,tempLength);
        }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));


    }
}
