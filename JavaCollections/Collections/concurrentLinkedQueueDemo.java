import java.util.concurrent.ConcurrentLinkedQueue;

public class concurrentLinkedQueueDemo {
    // Thread-safe, non-blocking queue.
    // It allows multiple threads to add and remove elements concurrently without locking, making it highly scalable for producer-consumer scenarios.
    // Unlike blocking queues
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> taskQueue = new ConcurrentLinkedQueue<>();

        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    taskQueue.add("Task " + System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    String task = taskQueue.poll();
                    System.out.println("Processing: " + task);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
