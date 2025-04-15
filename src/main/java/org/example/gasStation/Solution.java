package org.example.gasStation;

import java.util.Scanner;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int maxLength = gas.length;

        int[] t = new int[maxLength];

        int totalGasLeft = 0;

        for (int i = 0; i < maxLength; i++) {
            t[i] = gas[i] - cost[i];

            totalGasLeft += t[i];
        }

        if (totalGasLeft < 0) {
            return -1;
        } else {
            if(maxLength == 1){
                return 0;
            }

            Integer startIndex = null;

            int gasLeft = 0;

            int i = 0;

            while (true) {

                if (t[i] > 0) {

                    if (startIndex == null) {
                        startIndex = i;
                        gasLeft = t[i];
                    } else if (startIndex != i) {
                        t[startIndex] = gasLeft;
                        startIndex = i;
                        gasLeft = t[i];
                    } else {
                        return startIndex;
                    }
                } else {
                    if(startIndex != null){
                        gasLeft += t[i];
                        t[i] = 0;
                    }
                }

                i = (i + 1) % maxLength;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",");

        int[] gas = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            gas[i] = Integer.parseInt(input[i]);
        }

        String[] input2 = scanner.nextLine().split(",");

        int[] cost = new int[input2.length];

        for (int i = 0; i < input2.length; i++) {
            cost[i] = Integer.parseInt(input2[i]);
        }

        Solution solution = new Solution();

        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}
