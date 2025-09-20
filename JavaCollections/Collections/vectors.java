
import java.util.Vector; 
// Vectors are synchronized making it "thread safe".
public class vectors{
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>(5,2);
        vector.add(2);
        vector.add(2);
        vector.add(2);
        vector.add(2);
        vector.add(2);
        System.out.println(vector.capacity());
        vector.add(2);
        System.out.println(vector.capacity());
        vector.clear();
        System.out.println(vector);

        //If we use array list here we wont get the desired output
        Vector<Integer> list = new Vector<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Size of list: " + list.size()); //Outout = 2000
    }
}