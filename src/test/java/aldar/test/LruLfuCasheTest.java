package aldar.test;

import org.junit.Assert;
import org.junit.Test;

import aldar.LFUCache;
import aldar.LruCache;

public class LruLfuCasheTest {

    @Test
    public void checkResultLRU() {
        String result = "cache={1=1, 4=4}";
        LruCache<String, String> lruAlgoritm = new LruCache(2);
        lruAlgoritm.put("1", "1");
        lruAlgoritm.put("2", "2");
        lruAlgoritm.put("3", "3");
        lruAlgoritm.put("1", "1");
        lruAlgoritm.put("4", "4");
        Assert.assertTrue(lruAlgoritm.toString().equals(result));
    }

    @Test
    public void checkResultLFU() {
        String result = "cache={1=ValueFrequency [value=1, frequency=2], 2=ValueFrequency [value=2, frequency=1], 5=ValueFrequency [value=5, frequency=0]}";
        LFUCache<String, String> lfualogoritm = new LFUCache<>(3);
        lfualogoritm.put("1", "1");
        lfualogoritm.put("2", "2");
        lfualogoritm.put("3", "3");
        lfualogoritm.get("1");
        lfualogoritm.get("2");
        lfualogoritm.get("1");
        lfualogoritm.put("4", "4");
        lfualogoritm.put("5", "5");
        Assert.assertTrue(lfualogoritm.toString().equals(result));
    }
}
