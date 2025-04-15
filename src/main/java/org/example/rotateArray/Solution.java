package org.example.rotateArray;

public class Solution {
    int[] nums, relocated;

    int k;

    int previousValue;

    public void rotate(int[] nums, int k) {
        this.nums = nums;

        relocated = new int[nums.length];

        this.k = k % nums.length;

        for(int i = 0; i < nums.length; i++){
            if(relocated[i] == 0){
                previousValue = nums[i];

                relocateValue(i);
            }
        }
    }

    private void relocateValue(int i){
        if(relocated[i] == 0){
            int j = i + k < nums.length ? i + k : k + i - nums.length;

            int tempValue = nums[j];

            nums[j] = previousValue;

            previousValue = tempValue;

            relocated[i] = 1;

            relocateValue(j);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        solution.rotate(nums, 3);

        int[] nums = {-1, -100, 3, 99};
        solution.rotate(nums, 2);

//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53};
//        solution.rotate(nums, 82);

//        int[] nums = {1, 2, 3};
//        solution.rotate(nums, 4);

//        int[] nums = {1, 2, 3, 4, 5, 6};
//        solution.rotate(nums, 5);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
