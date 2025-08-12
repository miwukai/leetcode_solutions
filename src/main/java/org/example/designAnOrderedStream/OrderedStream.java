package org.example.designAnOrderedStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderedStream {
    Map<Integer, String> map;

    int pointer = 1;

    public OrderedStream(int n) {
        map = new HashMap<>();
    }

    public List<String> insert(int idKey, String value) {

        List<String> output = new ArrayList<>();

        map.put(idKey, value);

        if(idKey == pointer){
            while(map.containsKey(idKey)){
                output.add(map.get(idKey));
                map.remove(idKey);
                idKey++;
            }
            pointer = idKey;
        }

        return output;
    }
}
