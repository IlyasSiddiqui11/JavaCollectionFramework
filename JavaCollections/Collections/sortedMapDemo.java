import java.util.SortedMap;
import java.util.TreeMap;

public class sortedMapDemo {
    // SortedMsp is a interface.
    // If we want to keep entries sorted on the basis of "Keys" we use SortedMap.
    
    // Imlementation class for SortedMap is TreeMap.

    public static void main(String[] args) {
        // For decending order we will give a comparator in TreeMap constructor.
        // Sorting for String we cannot use comparator instead we use "(a, b) -> b.compareTo(a)",
        // and "Comparator.reverseOrder()" in TreeMap constructor.
        SortedMap<String,Integer> newmap = new TreeMap<>();
        // Interal working of TreeMap is RED BLACK TREE (RBT) or Self Balancing Binary Search Tree.
        newmap.put("Alice", 59);
        newmap.put("Charlie", 82);
        newmap.put("Bob", 67);
        newmap.put("XYZ", 91);
        newmap.put("Ilyas", 53);
        System.out.println(newmap);
        // This will print the map in sorted manner according to their keys.
        // Same will happen for Integer key.

        System.out.println(newmap.firstKey());
        System.out.println(newmap.lastKey());
        System.out.println(newmap.headMap("Charlie")); // Excludes "Charlie"
        System.out.println(newmap.tailMap("Ilyas")); // Inclued "Ilyas"


        SortedMap<Integer,String> numMap = new TreeMap<>((a,b) -> b - a); // For decending order sorting.
        numMap.put(59,"Alice");
        numMap.put(82,"Charlie");
        numMap.put(67,"Bob");
        numMap.put(91,"XYZ");
        numMap.put(53,"Ilyas");
        System.out.println(numMap);
    }
}
