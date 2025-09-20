
import java.util.LinkedList;
import java.util.Stack;
    //Stack is inherited class of Vector class.
    //Therefore it has all the methods of vectors and properties like thread safety.
    //It only differs because it follows LIFO principle.
    //Since we can also use methods of Vector Class we can also add remove elements frfom between the stack.
public class stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(19);
        stack.push(10);
        stack.push(7);
        stack.push(2);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        //We can also use linked list as stack but since it is not synchronized we will only use it in single threaded environment.
        LinkedList<Integer> stack1 = new LinkedList<>();
        stack1.add(19);// push
        stack1.add(19);
        stack1.add(19);
        stack1.add(19);
        stack1.getLast(); //peek
        stack1.removeLast(); // pop

        // We can also use arraylist as stack but it makes code look a bit harder to read.
    }
}
