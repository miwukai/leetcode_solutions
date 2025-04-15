package org.example.removeDuplicatesFromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {

        int p1 = 1;
        int p2 = 0;

        while(p1 < nums.length){
            if(nums[p2] != nums[p1]){
                p2++;
                nums[p2] = nums[p1];
                p1++;
            } else {
                p1++;
            }
        }

        return p2 + 1;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {1,1,2};
        System.out.println(nums[s.removeDuplicates(nums) - 1]);
    }


}
