
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
// Sub-class of HashMap
public class linkedhashmap {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> linkedhashmap = new LinkedHashMap<>(12,0.3f,true); 
        // There is a double linked list along with the array like hashmap
        // Slower than hashmap due to the linked list. Also uses more memory compared to hashmap.


        // About initialCapacity, loadFactor and accessOrder:
        /* Default capacity = 16
        Default load factor = 0.75
        Threshold = 16 × 0.75 = 12
        So, when the 13th element is inserted, the HashMap resizes to 32 buckets.*/
        // AccessOrder is false by default but if it is true the output will show the recently used element in the last line of output.

        linkedhashmap.put("Apple", 1);
        linkedhashmap.put("Pineapple", 2);
        linkedhashmap.put("Orange", 3);
        // Order is mainitained in linked hash maps.

        linkedhashmap.get("Apple");

        for(Map.Entry<String,Integer> entry: linkedhashmap.entrySet()){
            System.out.println(entry.getKey() +": "+entry.getValue());
        }

        // We can also create a LinkedHashMap by a HashMap.
        HashMap<String,Integer> newhashmap = new HashMap<>();
        LinkedHashMap<String,Integer> newlinkedhashmap = new LinkedHashMap<>(newhashmap);
        
    }
}
