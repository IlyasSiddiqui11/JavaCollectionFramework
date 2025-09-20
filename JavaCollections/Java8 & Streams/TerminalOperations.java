import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
        List<Integer> asList = Arrays.asList(1,3,2,4);
        // 1. collect
        
        asList.stream().skip(10).limit(100).collect(Collectors.toList()); // Creates a list of 11 to 110 numbers
        asList.stream().skip(10).limit(100).toList(); // Does the same work used only in newer java versions.

        // 2. forEach
        asList.stream().forEach(x -> System.out.println(x));

        // 3. reduce : Comnines elements to produce a single result
        Optional<Integer> optionalInteger = asList.stream().reduce((x, y) -> x + y);
        Optional<Integer> optionalInteger1 = asList.stream().reduce((Integer::sum));// Same as above
        //Optional means this might return or not return a answer sometimes.
        System.out.println(optionalInteger.get());
        System.out.println(optionalInteger1);

        // 4. count
        System.out.println(asList.stream().filter(x -> x % 2 == 0).count()); // returns how many numbers are even

        // 5. anyMatch, allMatch & noneMatch --> Are short circuit operations
        asList.stream().anyMatch(x -> x == 3); // returns boolean
        asList.stream().allMatch(x -> x > 0);
        asList.stream().noneMatch(y -> y < 0);

        // 6. findFirst & findAny --> Are short circuit operations
        System.out.println(asList.stream().findFirst().get());
        System.out.println(asList.stream().findAny().get());

        // 7. toArray()

        Object[] array = Stream.of(1, 2, 3).toArray();

        // 8. min / max
        System.out.println("max: " + Stream.of(2, 44, 69).max((o1, o2) -> o1 - o2/*or  omparator.naturalOrder()*/));
        System.out.println("min: " + Stream.of(2, 44, 69).min(Comparator.naturalOrder()));

        // 9. forEachOrdered
        List<Integer> numbers0 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Using forEach with parallel stream:");
        numbers0.parallelStream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream:");
        numbers0.parallelStream().forEachOrdered(System.out::println);

        // Example: Filtering and Collecting Names
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        System.out.println(names.stream().filter(x -> x.length() > 3).toList());

        // Example: Squaring and Sorting Numbers
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println(numbers.stream().map(x -> x * x).sorted().toList());

        // Example: Summing Values
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers.stream().reduce(Integer::sum).get());

        // Example:  Counting Occurrences of a Character
        String sentence = "Hello world";
        System.out.println(sentence.chars().filter(x -> x == 'l').count());

        // Example
        // Streams cannot be reused after a terminal operation has been called
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
    }
}
