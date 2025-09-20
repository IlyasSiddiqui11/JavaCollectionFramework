import java.lang.ref.WeakReference;

public class garbageCollection {
    public static void main(String[] args) {
        // This is a strong reference.
        //     ||
        Phone phone = new Phone("Apple", "17 Pro Max");
        // Phone phone1 = new Phone("Samsung", "S24 Ultra");
        System.out.println(phone);
        // The reference for the object has been deleted from the heap memory so JVM automatically collects the garbage.
        
        // phone = null;
        // System.out.println(phone);

        // ---------Weak Reference-------------
        WeakReference<Phone> newWeakReference = new WeakReference<>(new Phone("Samsung", "S24 Ultra"));
        // WeakReference is considered as garbage by JVM when not in use.
        // On the other hand, StrongReference is not considered for garbage collection when not in use.
        System.out.println(newWeakReference.get());
        System.gc();// This suggest JVM to collect the garbage.
        try {
            Thread.sleep(5000);
        } catch (Exception ignored) {
        }

        System.out.println(newWeakReference.get());
    }
}

class Phone{
    String model;
    String brand;

    public Phone(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Phone [model=" + model + ", brand=" + brand + ", toString()=" + super.toString() + "]";
    }

    


}