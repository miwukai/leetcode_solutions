package org.example.lruCache;

public class LRUCache2 {
    private static class Node {
        Node before, after;
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;

    int capacity;

    Node head;

    Node tail;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = getNode(key);

        return node == null ? -1 : node.value;
    }

    public Node getNode(int key) {
        Node n = head;

        while (n != null) {
            if (n.key == key) {
                if (tail != n) {
                    if (head != n) {
                        n.before.after = n.after;
                    } else {
                        head = n.after;
                    }
                    n.after.before = n.before;

                    tail.after = n;
                    n.before = tail;
                    n.after = null;
                    tail = n;
                }
                return n;
            }
            n = n.after;
        }

        return null;
    }

    public void put(int key, int value) {
        Node node;
        if ((node = getNode(key)) != null) {
            node.value = value;
        } else {
            Node n = new Node(key, value);

            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.after = n;
                n.before = tail;
                tail = n;
            }

            size++;

            if (size > capacity) {
                head = head.after;
                head.before = null;
                size--;
            }
        }
    }

    public static void main(String[] args) {
//        LRUCache2 c = new LRUCache2(1);
//        c.put(2, 1);
//        System.out.println(c.get(1));

//        LRUCache2 c = new LRUCache2(2);
//        c.put(1, 1);
//        c.put(2, 2);
//        System.out.println(c.get(1));
//        c.put(3, 3);
//        System.out.println(c.get(2));
//        c.put(4, 4);
//        System.out.println(c.get(1));
//        System.out.println(c.get(3));
//        System.out.println(c.get(4));

        LRUCache2 c = new LRUCache2(1);
        System.out.println(c.get(6));
        System.out.println(c.get(8));
        c.put(12, 1);
        System.out.println(c.get(2));
        c.put(15, 11);
        c.put(5, 2);
        c.put(1, 15);
        c.put(4, 2);
        System.out.println(c.get(5));
        c.put(15, 15);
    }
}
