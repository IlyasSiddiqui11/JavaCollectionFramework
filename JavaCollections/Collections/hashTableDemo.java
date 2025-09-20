import java.util.Hashtable;

public class hashTableDemo {
    // HashTable is synchronized.(Thread safe)
    // In HashMap value can be null and only one key can be null,
    // But in HAshTable no key or value can be null.
    // HashTable is now a legacy class(It is not used now),
    // It has been replaced by ConcurrentHashMap.
    // Slower than HashMap because of synchronization.
    // Map uses binary search tree in case of collision but HashTable uses only linkedlist.
    // All the methods are synchronized even the "get".
    
    public static void main(String[] args) {
        Hashtable<Integer,String> hashtable = new Hashtable<>();
        // Functions here are the same as HashMap since HashTable implements it.
        // The only difference is:
        hashtable.put(2, null); // Throws exception.
        hashtable.put(null, "Nothing"); // Throws exception.
    }
}
