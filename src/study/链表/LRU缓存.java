package study.链表;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K,V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return true;
    }
    LRUCache(){
        super(MAX_ENTRIES,0.75f,true);
    }
}
public class LRU缓存 {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet());
    }
}
