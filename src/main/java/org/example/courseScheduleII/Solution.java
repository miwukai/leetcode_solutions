package org.example.courseScheduleII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList();

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList());
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Stack<Integer> stack = new Stack();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                stack.push(i);
            }
        }

        int[] result = new int[numCourses];

        int n = 0;
        while(!stack.isEmpty()){
            int cur = stack.pop();
            result[n++] = cur;

            List<Integer> list = graph.get(cur);
            for(Integer i : list){
                indegree[i]--;
                if(indegree[i] == 0){
                    stack.push(i);
                }
            }
        }

        if( n != numCourses){
            return new int[]{};
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,1},{3,2}};
        int[] result = solution.findOrder(numCourses, prerequisites);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
