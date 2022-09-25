package collectionsTest.hashmap;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
    public static void main(String[] args) {
        IdentityHashMap<Integer,String> iMap = new IdentityHashMap();
        Integer i1 = new Integer("10");
        Integer i2 = new Integer("10");

        iMap.put(i1,"Adil");
        iMap.put(i2,"Kundan");

        // IdentityHashMap compares the key by == operator and not use .equals() method for comparison
        System.out.println(iMap);
    }
}
