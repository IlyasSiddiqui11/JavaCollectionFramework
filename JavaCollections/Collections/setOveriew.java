import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class setOveriew {
    // Set is a collection that cannot contain duplicate elements.
    // Set uses HashMap therefore the operations are faster.
    // Time complexity for Finding and Inserting will be O(1).
    // Like Map had some implementations:
    // Map --> HashMap, LinkedHashMap, TreeMap, EnumMap
    // Set --> HashSet, LinkedHashSet, TreeSet, EnumSet
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet();
        set1.add(22);
        set1.add(69);
        set1.add(19);
        set1.add(1);
        set1.add(1);
        System.out.println("Hashset: "+ set1);

        Set<Integer> set2 = new LinkedHashSet();
        set2.add(22);
        set2.add(69);
        set2.add(19);
        set2.add(1);
        set2.add(1);
        System.out.println("LinkedHashset: "+set2);

        Set<Integer> set3 = new TreeSet();
        set3.add(22);
        set3.add(69);
        set3.add(19);
        set3.add(1);
        set3.add(1);
        System.out.println("Treeset: "+set3);


        // HashSet cannot be assigned to a NavigableSet reference.
        // We can also use NavigableSet for navigation methods.
        NavigableSet<Integer> set4 = new TreeSet();
        set4.add(22);
        set4.add(69);
        set4.add(19);
        set4.add(1);
        set4.add(1);

        System.out.println(set4.contains(12));
        System.out.println(set4.remove(67));
        set4.clear();
        System.out.println(set4.isEmpty());
        for(int i: set4){
            System.out.println(i);
        }

        // For thread safety

        Set<Integer> synchronizedSet4 = Collections.synchronizedSet(set4);
        // synchronizedSet4 this set is now sychronized but this is a copy of set4,
        // set4 itself is not thread safe.
        // but we should not use this Collections.synchronizedSet(); because if we use it in multi-threading the problem will be,
        // If a Thread1 is doing some work Thread2 cannot do its work until Thread1 is done.
        // Instead of this we will use "ConcurrentSkipListSet"

        ConcurrentSkipListSet<Integer> set5 = new ConcurrentSkipListSet<>();
        // Recommended for thread safety

        // UnmodifiableSet

        Set<Integer> immutableSet = Set.of(2,44,6,336,3,411,555,100,68,19,1,11);
        // In Map we could only provide 10 entries but in set we can provide as many as we want.
        
        Collections.unmodifiableSet(set1); // This is also a way to make any set immutable.
    }
}
