package org.example.countSpecialTriplets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int specialTriplets(int[] nums) {
        Map<Integer, List<Integer>> numIndexsMap = new HashMap<>();

        Map<Integer, Integer> indexMatchedBeforeNumMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            if(numIndexsMap.containsKey(nums[i] * 2)){
                indexMatchedBeforeNumMap.put(i, numIndexsMap.get(nums[i] * 2).size());
            }

            if(numIndexsMap.containsKey(nums[i])){
                numIndexsMap.get(nums[i]).add(i);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(i);
                numIndexsMap.put(nums[i],li);
            }

        }

        long result = 0;

        for(Map.Entry<Integer, Integer> e : indexMatchedBeforeNumMap.entrySet()){
            int k = e.getKey();
            int v = e.getValue();
            int totalNum = numIndexsMap.get(nums[k] * 2).size();

            if(nums[k] != 0){
                result += (long) v * (totalNum - v);
            } else {
                result += (long) v * (totalNum - v - 1);
            }

        }

        return (int)(result % 1000000007);
    }
}
