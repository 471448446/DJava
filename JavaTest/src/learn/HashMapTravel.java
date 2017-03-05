package learn;

import common.Utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 在取value值的時候：entrySet性能高於keySet，因為keyset要在遍历一次列表来取值。
 * 如果只取key值一樣的。
 * Created by better on 2017/3/5.
 */
public class HashMapTravel {

    static HashMap<String, Object> keySetMap = new HashMap<>();
    static HashMap<String, Object> enterySetMap = new HashMap<>();


    public static void main(String[] args) {
        prepareMap();
        long startTime=System.currentTimeMillis();
        keySetMap();
        Utils.log("keySet time="+String.valueOf(System.currentTimeMillis()-startTime));
        startTime=System.currentTimeMillis();
        entrySetMap();
        Utils.log("entrySet time="+String.valueOf(System.currentTimeMillis()-startTime));
    }

    private static void prepareMap() {
        for (int i = 0; i < 10; i++) {
            keySetMap.put(String.valueOf(i), "keySet=" + i);
        }
        for (int i = 0; i < 10; i++) {
            enterySetMap.put(String.valueOf(i), "entrySet=" + i);
        }
    }

    private static void keySetMap() {
        Iterator<String> iterator = keySetMap.keySet().iterator();
        String key;
        while (iterator.hasNext()) {
            //取值
            key = iterator.next();
            Utils.log("keySet:" + key + "," + keySetMap.get(key));
            //值取key值
//            Utils.log("keySet:"+iterator.next());
        }
    }

    private static void entrySetMap() {
        Iterator<Map.Entry<String, Object>> iterator = enterySetMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            Utils.log("entry:" + entry.getKey() + "," + entry.getValue());
        }
    }
}
