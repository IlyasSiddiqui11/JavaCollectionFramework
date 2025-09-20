import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class copyOnWriteArraysSetDEmo {
    public static void main(String[] args) {
        // Works on Copy & Write Mechanism just like CopyOnWriteArrayList
        // The major difference is that no duplicate elements are present in CopyOnWriteArraysSet.
        // Thread-Safe.

        // While iterating if we add another value. The addition of value in the set is done after he iteration of loop.
        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>(); // Used when less writing and more reading, also used when iterating more.
        // CopyOnWriteArraySet is called strongly consistent.
        ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>(); // Used when constant read or write operations are done.
        // ConcurrentSkipListSet is called weakly consistent.


        for(int i = 0;i <= 5; i++){
            set.add(i);
            skipListSet.add(i);
        }
        System.out.println("Initial CopyOnWriteArraySet: " + set);
        System.out.println("Initial ConcurrentSkipListSet: " +skipListSet);

        System.out.println("Iterating and moifying CopyOnWriteArraySet: ");

        for(Integer num : set){
            System.out.println(num);
            set.add(6); // Not modified during iteration.
        }

        System.out.println("Iterating and moifying ConcurrentSkipListSet: ");
        for(Integer num : skipListSet){
            System.out.println(num);
            skipListSet.add(6); // modified during iteration.
        }
    }
}
