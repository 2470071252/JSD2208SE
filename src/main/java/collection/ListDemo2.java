package collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        /*
        list.add(3,"six");
        System.out.println(list);

        list.remove(3);
        System.out.println(list);
        */
        list.add(3,"six");
        System.out.println(list);

        list.remove(3);
        System.out.println(list);
    }
}
