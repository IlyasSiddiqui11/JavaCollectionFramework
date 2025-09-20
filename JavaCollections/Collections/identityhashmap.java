import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class identityhashmap{
    public static void main(String[] args) {
        String key1 = new String("key");
        String key2 = new String("key");
        // --------MAP-----------
        Map<String,Integer> map = new HashMap<>();
        System.out.println(key1.hashCode());
        System.out.println(key2.hashCode());
        // Both key1 and key2 are at the same place or memory location.
        // Here it checks Hashcode and equals (function)
        map.put(key1, 1);// key,1
        map.put(key2, 2);// key,2
        // Therfore the only entry in the map here is key2 as it is the latest key-value pair it replaces key1.
        // This checks the key before putting any key-value pair.
        // If the keys are same then the hashcode will be same and the size remains 1.
        System.out.println(map);

        // -------IDENTITY HASHMAP----------
        Map<String,Integer> identityhashMap = new IdentityHashMap<>();
        // Here in IdentityHashMap adress of both of the objects will be different.
        // And hence the hashcode for both of the objects will be different.
        String key3 = new String("key");
        String key4 = new String("key");
        System.out.println(System.identityHashCode(key3));
        System.out.println(System.identityHashCode(key4));
        // Here it checks IdentityHashCode and == (equality)
        identityhashMap.put(key3, 1);
        identityhashMap.put(key4, 2);
        // It does not check the key it checks the hashcode if the hashcode for the entry is different new entry will be made.
        // If the hashcode is same the key-value pair will be replaced.
        System.out.println(identityhashMap);
    }
}
