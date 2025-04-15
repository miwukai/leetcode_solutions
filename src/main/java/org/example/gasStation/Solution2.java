package org.example.gasStation;

public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int maxLength = gas.length;

        int[] t = new int[maxLength];

        int totalGasLeft = 0;

        int gasLeft = 0;

        int startIndex = 0;

        for (int i = 0; i < maxLength; i++) {
            t[i] = gas[i] - cost[i];

            totalGasLeft += t[i];

            gasLeft += t[i];

            if(gasLeft < 0){
                gasLeft = 0;

                startIndex = i + 1;
            }
        }

        return totalGasLeft < 0 ? -1 : startIndex;
    }
}
