import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class streamsDemo {
    public static void main(String[] args) {
        // feature introduced in Java 8
        // process collections of data in a functional and declarative manner
        // Simplify Data Processing
        // Embrace Functional Programming
        // Improve Readability and Maintainability
        // Enable Easy Parallelism

        //// What is stream ?
        // a sequence of elements supporting functional and declarative programming.
        // We can convert any Collection into stream in order to do functional and declarative programming.

        //// How to Use Streams ?
        // Source, intermediate operations & terminal operation

        List<Integer> list = Arrays.asList(1,2,3,4);
        // If we want to know how many even numbers are there in this list:
            // Traditonal way:-
        int count = 0;
        for(int i : list){
            if (i % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);

            // Using Streams:-
        System.out.println(list.stream().filter(x -> x % 2 == 0).count());
        // Here, Source = list, Intermediate operation = filter & Terminal operation = count.

        // Creating Streams
            // 1. From collections
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list2.stream();
            // 2. From Arrays
        String[] array = {"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(array);
            // 3. Using Stream.of()
        Stream<String> stream2 = Stream.of("a", "b");
        Stream<Integer> stream3 = Stream.of(1,2,3);
            // 4. Infinite streams
        Stream.generate(() -> 1);// We add .limit() to make it's size finite.
        Stream.iterate(1, x -> x + 1);
    }
}
