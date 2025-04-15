package org.example.evaluateDivision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> mapA = new HashMap();

        for(int i = 0; i < equations.size(); i++){
            String x = equations.get(i).get(0);

            String y = equations.get(i).get(1);

            Map<String, Double> mapB = mapA.getOrDefault(x, new HashMap());

            mapB.put(y, values[i]);

            if(mapA.containsKey(y)){
                Map<String, Double> mapC = mapA.get(y);

                for(Map.Entry e : mapC.entrySet()){
                    mapB.put((String)e.getKey(), values[i] * (Double) e.getValue());
                }
            }

            mapA.put(x, mapB);

            Map<String, Double> mapD = mapA.getOrDefault(y, new HashMap());

            mapD.put(x, 1/values[i]);

            if(mapA.containsKey(x)){
                Map<String, Double> mapE = mapA.get(x);

                for(Map.Entry e : mapE.entrySet()){
                    mapD.put((String)e.getKey(), 1/values[i] * (Double) e.getValue());
                }
            }

            mapA.put(y, mapD);

        }

        double[] result = new double[queries.size()];

        for(List<String> query : queries){
            String x = query.get(0);

            String y = query.get(1);

            if(!mapA.containsKey(x) || !mapA.containsKey(y)){
                result[queries.indexOf(query)] = -1.0;
                continue;
            }

            if(x.equals(y)){
                result[queries.indexOf(query)] = 1.0;
                continue;
            }

            Map<String, Double> mapB = mapA.get(x);

            if(mapB.containsKey(y)){
                result[queries.indexOf(query)] = mapB.get(y);
            } else {
                result[queries.indexOf(query)] = -1.0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> li1 = new ArrayList<>();
        li1.add("a");
        li1.add("b");

        List<String> li2 = new ArrayList<>();
        li2.add("b");
        li2.add("c");

        List<List<String>> equations = new ArrayList<>();
        equations.add(li1);
        equations.add(li2);

        double[] values = {2.0, 3.0};

        List<String> li3 = new ArrayList<>();
        li3.add("a");
        li3.add("c");

        List<String> li4 = new ArrayList<>();
        li4.add("b");
        li4.add("a");

        List<String> li5 = new ArrayList<>();
        li5.add("a");
        li5.add("e");

        List<String> li6 = new ArrayList<>();
        li6.add("a");
        li6.add("a");

        List<String> li7 = new ArrayList<>();
        li7.add("x");
        li7.add("x");

        List<List<String>> queries = new ArrayList<>();
        queries.add(li3);
        queries.add(li4);
        queries.add(li5);
        queries.add(li6);
        queries.add(li7);

        double[] result = solution.calcEquation(equations, values, queries);
        for (double res : result) {
            System.out.println(res);
        }
    }
}
