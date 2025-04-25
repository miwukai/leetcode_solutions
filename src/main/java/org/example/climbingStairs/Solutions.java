package org.example.climbingStairs;

import java.util.HashMap;
import java.util.Map;

public class Solutions {
    Map<Integer, Integer> map = new HashMap();

    public int climbStairs(int n) {
        map.put(1, 1);
        map.put(1, 2);

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int result;

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            result = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, result);
        }

        return result;
    }
}

