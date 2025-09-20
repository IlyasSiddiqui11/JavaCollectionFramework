
import java.util.ArrayList;
import java.util.Comparator;
// We use Comparator when we have to write our own logic to compare the objects.
class myComperator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
class myStringComperator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }
}
public class comperator {
    public static void main(String[] args) {
        // ArrayList<Integer> nums = new ArrayList<>();
        // nums.add(3);
        // nums.add(11);
        // nums.add(7);
        // nums.add(10);
        // nums.add(44);
        // nums.add(54);

        // nums.sort(new myComperator());
        // System.out.println(nums);
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Ilyas",6.89));
        students.add(new Student("ABCD",8.55));
        students.add(new Student("XYZ",6.67));
        students.add(new Student("Mango",6.67));

        Comparator<Student> comparing = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
        students.sort(comparing);
        students.sort((o1,o2) -> {
            if(o1.getGpa() - o2.getGpa() > 0){
                return -1;
            }
            else if(o1.getGpa() - o2.getGpa() < 0){
                return 1;
            }
            else{
                return 0;
            }
        });
        for(Student s : students){
            System.out.println("Name: " + s.getName() + "\nGPA: " + s.getGpa());
        }



        //                               //methood reference
        // students.sort(Comparator.comparing(Student::getAge));
        // students.sort(Comparator.comparing((Student s) -> s.getAge())); 
        //                                       //Lambda expression

        // System.out.println(students);
        
    }
}
class Student implements Comparable<Student>{
    private String name;
    private Double gpa;

    Student(String name, Double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public Double getGpa() {   // getter for age
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