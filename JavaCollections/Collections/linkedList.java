
import java.util.Arrays;
import java.util.LinkedList;

public class linkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedlist = new LinkedList<>();
        linkedlist.add(22);
        linkedlist.add(1);
        linkedlist.add(45);
        linkedlist.add(2);
        linkedlist.add(0, 212);
        linkedlist.remove(4);
        System.out.println(linkedlist);
        linkedlist.removeIf(x -> x %2==0);
        System.out.println(linkedlist);
        linkedlist.addFirst(100);
        System.out.println(linkedlist);

        LinkedList<String> cats = new LinkedList<>(Arrays.asList("Cat","Zebra","Lion","Puma","Tiger"));
        LinkedList<String> notcat = new LinkedList<>(Arrays.asList("Dog","Elephant","Zebra"));
        cats.removeAll(notcat);
        System.out.println(cats);

    }
}
