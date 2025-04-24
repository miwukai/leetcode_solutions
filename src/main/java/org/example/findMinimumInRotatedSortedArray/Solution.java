package org.example.findMinimumInRotatedSortedArray;

public class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];

        int start = 0;

        int end = nums.length - 1;

        int mid = nums.length / 2;

        while (start != end) {
            if (nums[mid] > min) {
                if (start == mid) {
                    return min > nums[end] ? nums[end] : min;
                }
                start = mid;
            } else if (nums[mid] < min) {
                end = mid;
                min = nums[mid];
            } else {
                return nums[mid];
            }

            mid = start + (end - start) / 2;
        }

        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{2, 3, 1}));
    }
}
