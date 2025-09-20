import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Java08 {
    public static void main(String[] args) {
        
        // Java 8 --> minimal code writing, functional programming features are added
        //      --> Lambda expression, Streams, Date and Time API.
        
        // LAMBDA EXPRESSION
        // lambda expression is an anonymous function ( no name, no return type, no access modifier )
        // They are only used for FuntionalInterfaces
            // Functional interface is an interface which has only one abstract method.
            // Note: There can be many other methods in that interface which are "default" or "static".
            // But only one function can be abstract.

        Thread t1 = new Thread(()->{
            System.out.println("HEY");
        });

        MathOperations add = (a,b) -> a + b;
        add.operate(3, 4);
        MathOperations sub = (a,b) -> a - b;
        MathOperations multipy = (a,b) -> a * b;
        MathOperations divide = (a,b) -> a / b;
        // This is called Functional Programming.

        // PREDICATE
        // Predicate is a functional interface. (Boolean value function)
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        System.out.println(isEven.test(3));

        Predicate<String> startsWithI = (x) -> x.toLowerCase().startsWith("i");
        Predicate<String> endsWithS = (x) -> x.toLowerCase().endsWith("s");
        Predicate<String> and = startsWithI.and(endsWithS);
        System.out.println(and.test("Ilyas"));

        // FUNCTION
        Function<Integer,Integer> doubleIt = (x) -> 2 * x;
        //         ||       ||
        //     parameter   return datatype
        Function<Integer,Integer> tripleIt = x -> 3 * x;
        doubleIt.andThen(tripleIt).apply(20); // 20 x 2 = 40 and then 40 x 3 = 120

        System.out.println(doubleIt.apply(2));

        Function<Integer, Integer> identity = Function.identity();
        Integer res2 = identity.apply(5);
        System.out.println(res2);

        // CONSUMER
        Consumer<Integer> print = x -> System.out.println(x);
        // Does not return anything
        print.accept(5);
        List<Integer> list = Arrays.asList(1,2,3);
        Consumer<List<Integer>> printList = x -> {
            for(int i : x){
                System.out.println(i);
            }
        };
        printList.accept(list);

        // SUPPLIER
        Supplier<String> printsHelloWorld = () -> "Hello World";
        // Does not take any argument. Only returns output.
        System.out.println(printsHelloWorld.get());

        // COMBINED EXAMPLE OF THE ABOVE TOPIC
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }

        // BiPredicate, BiConsumer, BiFunction

        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        System.out.println(isSumEven.test(5, 5));
        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();
        System.out.println(biFunction.apply("a", "bc"));

         // UnaryOperator, BinaryOperator
        UnaryOperator<Integer> a = x -> 2 * x; // Used for replacement of FUNCTION when return and parameter both are of same data type.
        //Function<Integer,Integer> tripleIt = x -> 3 * x;

        BinaryOperator<Integer> b = (x, y) -> x + y; // Used as replacement of BiFunction when both the parameters and also the return type are of same data type.

        // Method reference --> use method without invoking & in place of lambda expression
        List<String> students = Arrays.asList("Ram", "Shyam", "Ghanshyam");
        students.forEach(x -> System.out.println(x));
        students.forEach(System.out::println);

        // Constructor reference
        List<String> names = Arrays.asList("a","b","c");
        List<MobilePhone> mobilePhones = names.stream().map(MobilePhone::new).collect(Collectors.toList());
    }
}
// Let see this with an interface.
@FunctionalInterface 
// "@" is called Annotation
// Achi Aadat(Good habit) it will help compiler to throw error if we go against the defination of functional interface.

interface MathOperations {
    public int operate(int a, int b);
}

class MobilePhone{
    String name;

    public MobilePhone(String name) {
        this.name = name;
    }
}
