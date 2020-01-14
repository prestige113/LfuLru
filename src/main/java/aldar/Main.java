package aldar;

public class Main {

    public static void main(String[] args) {
	// write your code here

        LruCache<String, String> lruAlgoritm = new LruCache(2);
        lruAlgoritm.put("1", "1");
        lruAlgoritm.put("2", "2");
        lruAlgoritm.put("3", "3");
        lruAlgoritm.put("1", "1");
        lruAlgoritm.put("4", "4");
        System.out.println(lruAlgoritm);
        LFUCache<String, String> lfualogoritm =  new LFUCache<>(3);
        lfualogoritm.put("1", "1");
        lfualogoritm.put("2", "2");
        lfualogoritm.put("3", "3");
        lfualogoritm.get("1");
        lfualogoritm.get("2");
        lfualogoritm.get("1");
        lfualogoritm.put("4", "4");
        lfualogoritm.put("5", "5");
        System.out.println(lfualogoritm);
    }
}
