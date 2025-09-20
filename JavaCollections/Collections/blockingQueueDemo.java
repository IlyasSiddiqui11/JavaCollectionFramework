import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class blockingQueueDemo {
    // Thread safe queue
    // This queue waits for an element to be removed if it is full and we are adding another element.
    // This queue waits for an element to be added if it is empty and we are removing an element.
    // Simplify concurrency problems like producer and consumer.
    // In standard Queue the operations are done immediately.
        // IF empty and we want to remove element it does not wait.
        // Full --> add (no waiting).
    // In BlockingQueue 
        // put -->  Blocks if the queue is full until space becomes available.
        // take --> Blocks if the queue is empty until an element becomes available.
        // offer --> Waits for space to become available, up to the specified timeout.
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        // A bounded blocking queue backed by an circular array.
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        // low memory overhead
        // uses a single lock for both enqueue and dequeue operations
        // more threads --> problem
        // We will use ArrayBlockingQueue when there are less number of threads.
        
        producer.start();
        consumer.start();

        BlockingQueue<Integer> queue1 = new LinkedBlockingQueue<>();
        // Optionally bounded backed by LinkedList
        // Uses two separate locks for enqueue and dequeue operations
        // Higher concurrency between producers and consumers
        // We will use LinkedBlockingQueue when number of threads are more.
        
        BlockingQueue<Integer> queue2 = new PriorityBlockingQueue<>();
        // Same as PriorityQueue
        // Binary Heap as array and can grow dynamically.
        // Unordered
        // Head is based on their natural ordering or a provided Comparator like priority queue.
        // Since it is unbounded put(); wont block the thread.

        BlockingQueue<Integer> queue3 = new SynchronousQueue<>();
        // Elements wil be ordered.
        // Each insert operation must wait for a corresponding remove operation by another thread and vice versa.
        // It cannot store elements, capacity of at most one element.
        
        // Example of SynchronousQueue is in another file "synchronousQueueDemo"
    }
}

class Producer implements Runnable{
    private BlockingQueue<Integer> queue;
    private int value = 0;

    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Producer produced: " + value);
                queue.put(value++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted.");
            }
        }
    }
}

class Consumer implements Runnable{
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Integer value = queue.take();
                System.out.println("Consumer consumed: " + value);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted.");
            }
        }
    }

}
