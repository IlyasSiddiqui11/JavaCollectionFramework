import java.util.concurrent.ConcurrentSkipListMap;

public class concurrentskiplistmap {
    // It is like a Thread Safe TreeMap.
    // Data stored here is stored in a data structure called SkipList.
    // SkipList is a Probabilistic Data Structure, that allows efficient search, insertion and deletion operations.
    // It is similar to a sorted LinkedList but with MULTIPLE LAYERS that "skips" over portions of the list to provide faster access to elements
    // Example -> This is a List {1,2,3,4,5,6,7,8,9}
    // So, I want to store these above elements in SkipList --> Sorted, Multiple Layers & Fast Access.
    // Layer 1: 1,2,3,4,5,6,7,8,9
    // Layer 2: 1,..,3,..,5,..,7,..,9
    // Layer 3: 1,....5,....9
    // If we want to search an element (Let the element be 2) in this list it starts from the 3rd layer from 1 to 5 element not found,
    // It will go the 2nd layer since 2 is also skipped in 2nd layer it will go to the 1st layer and the element is found.
    // Time complexity: O(log n)
    public static void main(String[] args) {
        ConcurrentSkipListMap<String,Integer> map = new ConcurrentSkipListMap<>();
        // ConcurrentSkipListMap is Concurrent version of TreeMap.
        // ConcurrentHashMap is concurrent version of HashMap.
        // We can also use ConcurrentSkipListMap in Multi-Threaded environment.

        // SAME FUNCTIONS ARE AVAILABLE HERE.

    }
}
