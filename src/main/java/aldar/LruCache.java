package aldar;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {

    private LRUCache cache;

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public LruCache(int size) {
        if(size==0)
            new Exception("");
        this.cache = new LRUCache(size);
    }

    private class LRUCache extends LinkedHashMap<K, V> {

        private final int max_size;

        private LRUCache(int max_size) {
            this.max_size = max_size;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > max_size;
        }

    }

    @Override
    public String toString() {
        return "cache=" + cache;
    }
}
