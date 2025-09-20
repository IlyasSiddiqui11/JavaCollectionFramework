import java.util.EnumMap;

public class enumMapDemo {
    
    public static void main(String[] args) {
        EnumMap<Day,String> map = new EnumMap<>(Day.class);
        // No Hashing is done here,
        // Works on ordinal (index of enum)
        // Faster than HashMap and also memory efficient.

        map.put(Day.Tuesday,"Code" ); // Also maintains order.
        map.put(Day.Monday,"Code" );
        String s = map.get(Day.Tuesday);
        System.out.println(s);
        System.out.println(map);
    }
}

enum Day{
    Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday;
}
