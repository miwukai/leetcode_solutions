package org.example.houseRobber;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map = new HashMap();

    public int rob(int[] nums) {

        if(nums.length >= 1){
            map.put(0,nums[0]);
        }

        if(nums.length >= 2){
            map.put(1,Math.max(nums[0], nums[1]));
        }

        return findMax(nums, nums.length - 1);
    }

    int findMax(int[] nums, int index){

        if(map.containsKey(index)){
            return map.get(index);
        } else {
            int result = Math.max(findMax(nums, index - 1), findMax(nums, index - 2) + nums[index]);
            map.put(index, result);
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        System.out.println(solution.rob(nums)); // Output: 12
    }
}
