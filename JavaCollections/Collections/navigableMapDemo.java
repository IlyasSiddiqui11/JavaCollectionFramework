import java.util.NavigableMap;
import java.util.TreeMap;

public class navigableMapDemo {
    // Navigable is an interface that extends SortedMap.
    // TreeMap implements NavigableMap.
    public static void main(String[] args) {
        NavigableMap<Integer,String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "Uno");
        navigableMap.put(3, "Tres");
        navigableMap.put(2, "Dos");
        System.out.println(navigableMap);
        System.out.println(navigableMap.firstEntry());
        System.out.println(navigableMap.lowerKey(4));
        System.out.println(navigableMap.ceilingKey(3));
        System.out.println(navigableMap.higherEntry(1));
        System.out.println(navigableMap.descendingMap());
        // We use NavigableMap when we want a range of output.
        // We use SortedMap when we want a particular value in output.
    }
}
