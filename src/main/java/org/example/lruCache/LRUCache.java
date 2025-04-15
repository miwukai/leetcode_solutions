package org.example.lruCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private static class removeEldestEntryLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private static final long serialVersionUID = 1L;
        private final int capacity;

        public removeEldestEntryLinkedHashMap(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    Map<Integer, Integer> linkedHashMap;

    public LRUCache(int capacity) {
        linkedHashMap = new removeEldestEntryLinkedHashMap(capacity);
    }

    public int get(int key) {
        return linkedHashMap.get(key) == null ? -1 : linkedHashMap.get(key);
    }

    public void put(int key, int value) {
        linkedHashMap.put(key, value);
    }

    public static void main(String[] args){
        LRUCache c = new LRUCache(2);

        c.put(1,1);
        c.put(2,2);
        System.out.println(c.get(1));
        c.put(3,3);
        System.out.println(c.get(2));
        c.put(4,4);
        System.out.println(c.get(1));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
    }
}
