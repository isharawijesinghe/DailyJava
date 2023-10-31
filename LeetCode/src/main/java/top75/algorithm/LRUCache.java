package top75.algorithm;

import java.util.*;

public class LRUCache {

    Deque<Node> dll;
    HashMap<Integer, Node> hm;
    int size;


    public LRUCache(int capacity) {
        dll = new LinkedList<>();
        hm = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if (hm.containsKey(key)){
            Node returnNode = hm.get(key);
            dll.remove(returnNode);
            dll.addFirst(returnNode);
            return returnNode.getValue();
        }
        return -1;

    }

    public void put(int key, int value) {
        if (!hm.containsKey(key)){
            if (size == dll.size()){
                Node node = dll.removeLast();
                hm.remove(node.getKey());
            }
        } else {
            Node node = hm.remove(key);
            dll.remove(node);
        }
        Node newNode = new Node(key, value);
        hm.put(key, newNode);
        dll.addFirst(newNode);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);

        System.out.println(lruCache.get(1));

        System.out.println(lruCache.get(2));

    }

}

class Node {
    private int key;
    private int value;

    public Node(int key, int value){
        this.setKey(key);
        this.setValue(value);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}