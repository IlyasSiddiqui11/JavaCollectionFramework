import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class queue {
    // Follows FIFO principle.

    public static void main(String[] args) {
        // We can also make Linkelist act as queue.
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(22); // enqueue
        list.addLast(11); // enqueue
        list.addLast(1); // enqueue
        list.addLast(19); // enqueue
        System.out.println(list);
        list.removeFirst(); // dequeue
        System.out.println(list);
        System.out.println(list.getFirst()); // peek
        // But if we use linked list to make a queue we have plenty of methods of linked list that has no use in queue.
        // Therefore we have Queue interface.

        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);// We dont have to do add last as it already knows.
        queue.remove();// Same here it knows the first element will be removed.

        //queue.remove();// remove(); throws exception if queue is already empty.
        queue.poll(); // Does not throw exception if queue is already empty.

        queue.peek(); // Does not throw exception if queue is already empty.
        //queue.element(); // Throws exception if queue is already empty

        System.out.println(queue);
        
        Queue<Integer> queue2 =  new ArrayBlockingQueue<>(2);
        System.out.println(queue2.add(1)); // Returns boolean if added: true
        System.out.println(queue2.offer(2)); // true

        System.out.println(queue2.offer(3)); // False 
        System.out.println(queue2.add(3)); // Throws exception 
    }
}
