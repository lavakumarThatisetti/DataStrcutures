package LRU;

import java.util.*;

class LRUCache {

    private final LinkedHashMap<Integer, Integer> linkHashMap;

    public LRUCache(int capacity) {
        linkHashMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public void put(int key, int value) {
        linkHashMap.put(key, value);
    }

    public int get(int key) {
        return linkHashMap.getOrDefault(key, -1);
    }

}

public class LRUWithLHM {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        List<Integer> arrayList = Arrays.asList(1,2,1,4,5,1,6,7);
        for(Integer i:arrayList){
            lruCache.put(i,i);
        }
    }
}
