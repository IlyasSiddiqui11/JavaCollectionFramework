import java.util.LinkedHashMap;



public class LRUcache<K,V> extends LinkedHashMap<K,V> {
    private int capacity;

    public LRUcache(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        // TODO Auto-generated method stub
        return size() > capacity;
    }
    public static void main(String[] args) {
        LRUcache<String,Integer> newStudent = new LRUcache<>(3);
        newStudent.put("Bob", 62);
        newStudent.put("Ilyas", 66);
        newStudent.put("Alice", 33);

        // If we add another element to this map the eldest element will be removed once the capacity is exceeded.
        // The method removeEldestEntry is automatically called when we put another key-value pair.

        // If we try to get the removed eldest element we would 
        // Output --> "Alice" - "Bob" - "ABC" because the eldest entry here would be "Ilyas".
        newStudent.get("Bob");
        
        newStudent.put("ABC", 0);
        System.out.println(newStudent);
    }
}