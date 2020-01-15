package aldar;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LFUCache<K, V> implements Cache<K, V> {

    private Map<K, ValueFrequency> cache;

    private final long max_size;

    public LFUCache(int max_size) {
        if (max_size <= 0) {
            new IllegalArgumentException("Capacity should be more than 0");
        }
        this.max_size = max_size;
        this.cache = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        if (max_size == cache.size()) {
            K keyTemp = cache.entrySet().stream().min(Map.Entry.comparingByValue(Comparator.comparing(m -> m.frequency))).get().getKey();
            cache.remove(keyTemp);
            //System.out.println("deleted=" + keyTemp + " cacheSize=" + cache.size());
        }
        cache.put(key, new ValueFrequency(value, 0L));
    }

    @Override
    public V get(K key) {
        ValueFrequency valueFrequency = cache.get(key);
        if (valueFrequency == null) {
            return null;
        } else {
            valueFrequency.infrequency();
        }
        return cache.get(key).value;
    }

    private class ValueFrequency {

        private V value;
        private Long frequency;

        ValueFrequency(V value, Long frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        void infrequency() {
            frequency++;
        }

        @Override
        public String toString() {
            return "ValueFrequency [value=" + value + ", frequency=" + frequency + "]";
        }
    }

    @Override
    public String toString() {
        return "cache=" + cache;
    }
}
