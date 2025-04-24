package org.example.findKPairsWithSmallestSums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int x : nums1) {
            pq.offer(new int[] {x + nums2[0], 0});
        }

        while(k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int sum = pair[0];
            int pos = pair[1];

            List<Integer> li = new ArrayList<>();

            li.add(sum - nums2[pos]);
            li.add(nums2[pos]);

            list.add(li);

            if(pos + 1 < nums2.length) {
                pq.offer(new int[] {sum - nums2[pos] + nums2[pos + 1], pos + 1});
            }
            k--;
        }

        return list;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.kSmallestPairs(new int[]{1,2,4,5,6}, new int[]{3,5,7,9}, 20).forEach(i -> i.forEach(System.out::println));
    }

}
