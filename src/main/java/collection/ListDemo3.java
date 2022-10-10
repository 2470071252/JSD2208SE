package collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for ( int i = 10; i > 0; i-- ) {
            list.add(i);
        }
        System.out.println(list);

        List<Integer> sublist = list.subList(3,8);
        System.out.println(sublist);

        for ( int i =0;i<sublist.size();i++ ){
            Integer number = sublist.get(i)*10;
            sublist.set(i,number);
        }
        System.out.println(sublist);

        System.out.println(list);

        sublist.clear();
        System.out.println(list);
    }

}
