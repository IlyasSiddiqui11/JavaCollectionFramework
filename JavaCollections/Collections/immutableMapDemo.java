import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class immutableMapDemo {
    public static void main(String[] args) {
        HashMap<String,Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        Map<String, Integer> map2 = Collections.unmodifiableMap(map1); // We cannot make any changes in map2 
        System.out.println(map2.get("A"));
        // map2.put("c", 3);// throws exception
        // But anyone can change map1 directly, to solve this problem we have ImmutableMap.
        Map<String,Integer> map3 = Map.of("C", 3,"D",4);
        // This is how we create a ImmutableMap.
        // We cannot use "put" method on map3.
        map3.put("3", 69); // throws exception
        // In Map.of(); method we can only give 10 entries.
        // For more than 10 entries we should use Map.ofEntries(); method
        Map<String, Integer> map4 = Map.ofEntries(Map.entry("Ilyas", 33), Map.entry("Meow", 100));
        

    }
}
