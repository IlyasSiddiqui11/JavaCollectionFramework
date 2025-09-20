import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        IntStream stream = Arrays.stream(arr);
        // When we create a stream of primitive data type the stream used here is called primitive stream.
        // Integer[] arr1 = {1,2,3,4};
        // Stream<Integer> stream2 = Arrays.stream(arr1);
        // And while we create a stream of wrapper class (Integer) it will be stream normally.

        System.out.println(IntStream.range(1, 6).boxed().collect(Collectors.toList()));
        // Not using boxed here will throw an error.
        // boxed() is used to convert this into Wrapper class.
        System.out.println(IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toList()));

        IntStream.of(1, 2, 3);

        DoubleStream doubles = new Random().doubles(5);
        // System.out.println(doubles.sum());
        // System.out.println(doubles.min());
        // System.out.println(doubles.max());
        // System.out.println(doubles.average());
        // doubles.summaryStatistics();
        // doubles.mapToInt(x -> (int) (x + 1));

        // To run the above lines we have to comment this line below since this is boxed the stream is closed here.
        // And as we know we cannot use any stream once a terinal operation is done on it.
        System.out.println(doubles.boxed().toList());

        IntStream intStream = new Random().ints(5);
        System.out.println(intStream.boxed().toList());
    }
}
