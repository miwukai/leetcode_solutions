package org.example.evaluateDivision;

import java.util.*;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> mapA = new HashMap();

        for(int i = 0; i < equations.size(); i++){
            String x = equations.get(i).get(0);

            String y = equations.get(i).get(1);

            Map<String, Double> mapB = mapA.getOrDefault(x, new HashMap());

            mapB.put(y, values[i]);

            mapA.put(x, mapB);

            Map<String, Double> mapD = mapA.getOrDefault(y, new HashMap());

            mapD.put(x, 1/values[i]);

            mapA.put(y, mapD);

        }

        double[] result = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++){
            String x = queries.get(i).get(0);

            String y = queries.get(i).get(1);

            if(!mapA.containsKey(x) || !mapA.containsKey(y)){
                result[i] = -1.0;
                continue;
            }

            if(x.equals(y)){
                result[i] = 1.0;
                continue;
            }

            Set<String> keys = new HashSet<>();

            result[i] = findAnswer(mapA, x, y, 1.0, keys);

        }

        return result;
    }

    Double findAnswer(Map<String, Map<String, Double>> mapA, String x, String y, Double midVal, Set<String> keys){
        if(keys.contains(x)){
            return -1.0;
        }

        keys.add(x);

        Map<String, Double> mapB = mapA.get(x);

        if(mapB.containsKey(y)){
            return midVal * mapB.get(y);
        } else {
            Double result = -1.0;
            for(Map.Entry<String, Double> entry : mapB.entrySet()){
                result = Math.max(result, findAnswer(mapA, entry.getKey(), y, midVal * entry.getValue(), keys));
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> li1 = new ArrayList<>();
        li1.add("a");
        li1.add("k");

        List<String> li2 = new ArrayList<>();
        li2.add("a");
        li2.add("aaa");

        List<List<String>> equations = new ArrayList<>();
        equations.add(li1);
        equations.add(li2);

        double[] values = {10.0,1.0};

        List<String> li3 = new ArrayList<>();
        li3.add("aaa");
        li3.add("k");

        List<List<String>> queries = new ArrayList<>();
        queries.add(li3);

        double[] result = solution.calcEquation(equations, values, queries);
        for (double res : result) {
            System.out.println(res);
        }
    }
}
