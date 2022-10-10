package collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListDemo1 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);

        String l3 = list.get(3);
        System.out.println(l3);

        for (int i = 0; i<list.size();i++){
            String e = list.get(i);
            System.out.println(e);
        }

        String old = list.set(2,"six");
        System.out.println(list);
        System.out.println(old);

        for ( int i = 0 ; i<list.size()/2;i++ ){
            String l1 = list.get(i);
            String l2 = list.set(list.size()-1-i,l1);
            list.set(i,l2);

        }
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

    }
}
