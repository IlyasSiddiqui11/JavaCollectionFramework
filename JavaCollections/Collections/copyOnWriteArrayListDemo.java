
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
        // "Copy on Write" means that whenever a write operation
        // like adding or removing an element
        // instead of directly modifying the existing list
        // a new copy of the list is created, and the modification is applied to that copy
        // This ensures that other threads reading the list while it’s being modified are unaffected.

        // Read Operations: Fast and direct, since they happen on a stable list without interference from modifications.
        // Write Operations: A new copy of the list is created for every modification.
        // The reference to the list is then updated so that subsequent reads use this new list.

        // notepad --> notepad-copy

        // We use this we we worl with more read operations only and not write operations.
        // As this creates a new copy everytime it will consume more memory.
public class copyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Milk");
        list.add("Bread");
        list.add("Eggs");
        System.out.println("The initial list is: "+ list);
        System.out.println();
        for(String item:list){
            // We cannot do this in arraylist.
            // CopyOnWriteArrayList can do read and write operations together because the read operation is done on the first list.
            // The write operation is fone on the copy of that list.
            if(item.equals("Eggs")){
                list.add("Butter");
            }
        }
        // The list is updated after the execution of the loop above is done.
        System.out.println("Final List: ");
        list.forEach(newItem -> System.out.println(newItem));


        List<String> sharedList = new CopyOnWriteArrayList<>();
        // It would have thrown an exception if we used ArrayList here.
        sharedList.add("Item1");
        sharedList.add("Item2");
        sharedList.add("Item3");
        Thread readerThread = new Thread(() -> {
            try {
                int iterations = 5; // Number of times to read the list
                for (int i = 0; i < iterations; i++) {
                // Iterate through the list
                    for (String item : sharedList) {
                        System.out.println("Reading item: " + item);
                        Thread.sleep(100); // Small delay to simulate work
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception in reader thread: " + e);
            }
        });
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(500); // Delay to allow reading to start first
                sharedList.add("Item4");
                System.out.println("Added Item4 to the list.");

                Thread.sleep(500);
                sharedList.remove("Item1");
                System.out.println("Removed Item1 from the list.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        readerThread.start();
        writerThread.start();
    }
}
