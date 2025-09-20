
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Objects;
// HashMap is like a dictionary with key and value pairs every key or value has its mapped value or key.
// It is not synchronized.(Not thread safe)
// It has O(1) complexity for get and set both operations(WHEN NO COLLISIONS).

public class hashmap {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"Cat");
        map.put(2,"Dog");
        map.put(3,"ABC");
        map.put(null,"Bob");
        // If we set another value for the same key the previous value will be replaced by the new value.
        map.put(null,"Tom");
        // Here the new value for key "null" will be "Tom" not "Bob".
        // There can only be one null value for key but for value there can be many null values.

        // for(Integer i: map.keySet()){
        //     System.out.println(map.get(i));       
        // }
        
        System.out.println(map.containsKey(1));
        Set<Map.Entry<Integer,String>> entries = map.entrySet();
        for(Map.Entry<Integer,String> entry : entries){
            // System.out.println(entry);
            entry.setValue(entry.getValue().toUpperCase());

        }
        // System.out.println(map);

        person p1 = new person("Ilyas", 1);
        person p2 = new person("Aniket",2);
        person p3 = new person("Ilyas", 1);

        HashMap<person,String> map1 = new HashMap<>();

        map1.put(p1, "Engineer");
        map1.put(p2, "HR");
        map1.put(p3, "Manager");

        System.out.println("Size of HashMap: " + map1.size());
        System.out.println("Value for p1: " + map1.get(p1));
        System.out.println("Value for p3: " + map1.get(p3));

        HashMap<String,Integer> hashmap = new HashMap<>();

        hashmap.put("Bob", 90);
        hashmap.put("Alice", 70);
        hashmap.put("Jerry", 95);

        // Returns the value if the given key is found and if not than returns defaultValue.
        Integer value1 = hashmap.getOrDefault("Bob", 0);
        Integer value2 = hashmap.getOrDefault("Ilyas", 0);

        System.out.println(value1);
        System.out.println(value2);

        // Enters the given key-pair value if it is absent in the HashMap 
        // If it is already present than this function does not do any changes in the HashMap.k
        hashmap.putIfAbsent("Ilyas", 100);
        System.out.println(hashmap);

        hashmap.remove("Jerry");
        hashmap.remove("Bob", 90);
        for(Map.Entry<String,Integer> entry: hashmap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

class person{
    private String name;
    private int id;

    person(String name,int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        person other = (person) obj;
        return id == other.getId() && Objects.equals(name, other.getName());
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name;
    }
}