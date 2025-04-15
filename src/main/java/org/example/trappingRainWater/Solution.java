package org.example.trappingRainWater;

public class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int barSize = 0;
        int totalSize = 0;
        int startHeight = 0;

        while (height[left] == 0 && left < right) {
            left++;
        }

        while (height[right] == 0 && left < right) {
            right--;
        }

        while (left < right) {
                totalSize += (right - left + 1) * (Math.min(height[left], height[right]) - startHeight);

                startHeight = Math.min(height[left], height[right]);

                while (height[left] <= startHeight && left < right) {
                    barSize += height[left];
                    left++;
                }

                while (height[right] <= startHeight && left < right) {
                    barSize += height[right];
                    right--;
                }
        }

        return totalSize - barSize - Math.min(height[left], startHeight);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }
}
