package org.example.findFirstAndLastPositionOfElementInSortedArray;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int left = findLeft(nums, target, 0, nums.length - 1);
        int right = findRight(nums, target, 0, nums.length - 1);
        return new int[]{left, right};
    }

    int findLeft(int[] nums, int target, int start, int end) {
        int mid = start + (end - start) / 2;

        while (start != end) {
            if (nums[mid] >= target) {
                if (end - start == 1) {
                    return nums[mid] == target ? start : -1;
                }
                end = mid;
            } else {
                if (end - start == 1) {
                    return nums[end] == target ? end : -1;
                }
                start = mid;
            }
            mid = start + (end - start) / 2;
        }

        return nums[mid] == target ? start : -1;
    }

    int findRight(int[] nums, int target, int start, int end) {
        int mid = start + (end - start) / 2;

        while (start != end) {
            if (nums[mid] <= target) {
                if (end - start == 1) {
                    if(nums[end] == target){
                        return end;
                    }
                    return nums[mid] == target ? start : -1;
                }
                start = mid;
            } else {
                if (end - start == 1) {
                    return -1;
                }
                end = mid;
            }
            mid = start + (end - start) / 2;
        }

        return nums[mid] == target ? start : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.searchRange(new int[]{2, 2}, 2);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
