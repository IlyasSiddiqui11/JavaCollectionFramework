import java.util.ArrayList;
import java.util.List;

public class comparableDemo {
    public static void main(String[] args) {
        // We can find class "Student" is in comperator.java in this folder.
        List<Student> list = new ArrayList<>();
        // Comparator is written outside the class which is compare(o1,o2) method.
        // Comperator is used when we write our own logic of sorting in .sort() method.

        // Comparable is written in side the class with method ovverriding of method compareTo(o1).
        list.add(new Student("Ilyas",6.89));
        list.add(new Student("ABCD",8.55));
        list.add(new Student("XYZ",6.67));
        list.add(new Student("Mango",6.67));
        list.sort(null);
        // "null" automatically runs Comparable.
        System.out.println(list);
    }
}
// We have to implement this class with Comparable<>.

class Student implements Comparable<Student>{
    private String name;
    private Double gpa;

    Student(String name, Double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public Double getGpa() {
        return gpa;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.getGpa(), this.getGpa());
        // throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", gpa=" + gpa + "]";
    }
    
}
