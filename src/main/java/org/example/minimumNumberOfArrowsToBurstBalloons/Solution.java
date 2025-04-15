package org.example.minimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    if(o1[1] == o2[1]) {
                        return 0;
                    } else if(o1[1] < o2[1]) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else if(o1[0] < o2[0]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        int[] interval = points[0];

        int result = 1;

        for (int i = 1; i < points.length; i++) {
            if(points[i][0] <= interval[1]){
                interval[0] = points[i][0];
                interval[1] = Math.min(points[i][1], interval[1]);
            } else {
                interval[0] = points[i][0];
                interval[1] = points[i][1];
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] points = new int[][]{
                {9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}
        };
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(points));
    }
}
