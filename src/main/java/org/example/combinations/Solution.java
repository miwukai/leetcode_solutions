package org.example.combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return findNext(1, k, n);
    }

    List<List<Integer>> findNext(int i, int k, int n) {
        List<List<Integer>> output = new ArrayList();

        if (k == 0) {
            return null;
        }

        for (int j = i; j <= n - k + 1; j++) {
            List<List<Integer>> li = findNext(i + 1, k - 1, n);

            if (li == null) {
                List<Integer> m = new ArrayList();
                m.add(j);
                output.add(m);
            } else {
                for (List<Integer> l : li) {
                    l.add(j);
                    output.add(l);
                }
            }

            i++;
        }

        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(5, 3));
    }
}
