import java.util.concurrent.ConcurrentHashMap;

public class concurrenthashmapDemo {
    // Java 7 --> segment based locking --> 16 segments --> smaller hashmap.
    // Only the segment being written to or read from is locked
    // read: do not require locking unless there is a write operation happening on the same segment
    // write: lock

    // java 8 --> no segmentation
    //     --> Compare-And-Swap approach --> no locking except resizing or collision
    // Example: Compare and Swap
    // Thread A last saw --> x = 45
    // Thread A work --> x to 50
    // if x is still 45, then change it to 50 else don't change and retry
    // put --> index
    // When we put we will get an index then it will check if the index is empty then it will take that entry to put it then again it will check if the index is empty and will finally put it.

    // MAP --> SORTED --> THREAD SAFE --> ConcurrentSkipListMap
    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
        // Same functions are used.
    }
}
