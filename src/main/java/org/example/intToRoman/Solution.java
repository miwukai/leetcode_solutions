package org.example.intToRoman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> convertMap = new HashMap();

        convertMap.put(1, "I");
        convertMap.put(5, "V");
        convertMap.put(10, "X");
        convertMap.put(50, "L");
        convertMap.put(100, "C");
        convertMap.put(500, "D");
        convertMap.put(1000, "M");

        StringBuilder sb = new StringBuilder();

        int value = num / 1000;

        while (value > 0) {
            sb.append(convertMap.get(1000));
            value--;
        }

        num %= 1000;

        for (int i = 1; i < 1000; i *= 10) {
            value = num / (100 / i);

            if (value == 0) {
                continue;
            }

            if (value < 4) {
                while (value > 0) {
                    sb.append(convertMap.get(100 / i));
                    value--;
                }

            }

            if (value == 4) {
                sb.append(convertMap.get(100 / i)).append(convertMap.get(500 / i));
            }

            if (value > 4 && value < 9) {
                sb.append(convertMap.get(500 / i));
                value -= 5;
                while (value > 0) {
                    sb.append(convertMap.get(100 / i));
                    value--;
                }
            }

            if (value == 9) {
                sb.append(convertMap.get(100 / i)).append(convertMap.get(10 * 100 / i));
            }

            num %= (100 / i);

        }

        return sb.toString();


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(1));
    }
}
