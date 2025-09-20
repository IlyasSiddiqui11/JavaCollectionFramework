


import java.util.ArrayList;

public class arraylists{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(100);
        list.add(22);
        list.add(10);
        list.add(2, 43);//shifts
        list.set(0,1);//replaces the current element
        System.out.println(list);

        // for(int i = 0;i<list.size();i++){
        //     System.out.println(list.get(i));
        // }

        // for(int x: list){
        //     System.out.println(x);
        // }
    }
}