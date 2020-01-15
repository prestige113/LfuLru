package aldar;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> implements Cache<K, V> {

    private LRUStorage cache;

    @Override
    public V get(K key) {
        return cache.get(key);
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    public LruCache(int size) {
        if (size <= 0) {
            new IllegalArgumentException("Capacity should be more than 0");
        }
        this.cache = new LRUStorage(size);
    }

    private class LRUStorage extends LinkedHashMap<K, V> {

        private final int max_size;

        private LRUStorage(int max_size) {
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
