package org.example.jumpGameII;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public int jump(int[] nums) {
        int i = 0;

        Set<Integer> destSet = new HashSet();

        destSet.add(nums.length - 1);

        while (destSet.size() > 0) {

            i++;

            Set<Integer> tempSet = new HashSet();

            for (int dest : destSet) {
                for (int j = 0; j < dest; j++) {
                    if (dest - j <= nums[j]) {
                        if (j == 0) {
                            return i;
                        } else {
                            if(tempSet.size() == 0){
                                tempSet.add(j);
                            }
                        }
                    }
                }
            }

            destSet = tempSet;
        }

        return nums.length - 1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",");

        int[] nums = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        Solution solution = new Solution();

        System.out.println(solution.jump(nums));
    }
}
