package itcast.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("",2);
        System.out.println(hashtable.get("").toString());
        Map map = new HashMap();
        HashMap hashMap = new HashMap();
        hashMap.put(5,3);
        System.out.println(hashMap.get("5"));
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(3,5);

    }
}
