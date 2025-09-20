import java.util.PriorityQueue;

public class PriorityQueueDemo {
    // Part of Queue Interface.
    // orders elements based on their natural ordering (for primitives lowest first)
    // custom comparator for customised ordering
    // does not allow null elements
    public static void main(String[] args) {
        //We can also provide a comparator here in constructor for custom ordering.
        //For reverse ordering we can provide:
        // (x,y) -> y - x
        //Comparator.reverseOrder()
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(15);
        pq.add(10);
        pq.add(30);
        pq.add(5);
        System.out.println(pq); // not sorted
        while (!pq.isEmpty()){
            System.out.println(pq.poll()); // prints in priority.
        }

        // internal working
        // PriorityQueue is implemented as a min-heap by default (for natural ordering).
    }
}
