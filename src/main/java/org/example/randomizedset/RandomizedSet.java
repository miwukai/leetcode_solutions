package org.example.randomizedset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
    List<Integer> list;
    Map<Integer,Integer> map;

    public RandomizedSet() {
        list = new ArrayList();
        map = new HashMap();
    }

    public boolean insert(int val) {
        boolean result = map.containsKey(val);

        if(!result){
            list.add(val);
            map.put(val,list.size()-1);
        }

        return !result;
    }

    public boolean remove(int val) {
        boolean result = map.containsKey(val);

        if(result){
            int index = (int)map.get(val);

            if(index < list.size() - 1){
                int last = list.get(list.size()-1);
                list.set(index,last);
                map.put(last,index);
            }

            list.remove(list.size()-1);
            map.remove(val);
        }

        return result;
    }

    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.getRandom());
    }
}
