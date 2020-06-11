package learn.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashmap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map1 = new LinkedHashMap<>(8, 0.8f, true);
        System.out.println("put-----");
        map1.put(1, 1);
        printCache(map1);
        map1.put(2, 2);
        printCache(map1);
        map1.put(3, 3);
        printCache(map1);
        System.out.println("get-----");
        System.out.println(map1.get(1));
        printCache(map1);
        System.out.println(map1.get(2));
        printCache(map1);
        System.out.println(map1.get(3));
        printCache(map1);
        System.out.println("no use accessOrder");

        LinkedHashMap<Integer, Integer> map2 = new LinkedHashMap<>(8, 0.8f, false);
        System.out.println("put-----");
        map2.put(1, 1);
        printCache(map2);
        map2.put(2, 2);
        printCache(map2);
        map2.put(3, 3);
        printCache(map2);
        System.out.println("get-----");
        System.out.println(map2.get(1));
        printCache(map2);
        System.out.println(map2.get(2));
        printCache(map2);
        System.out.println(map2.get(3));
        printCache(map2);

    }

    public static void printCache(LinkedHashMap<Integer, Integer> map) {
        for (Iterator it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        System.out.println("------");
    }
}
