package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("范老师");
        list.add("刘桑");
        list.add("小凡老师");
        System.out.println(list);

        list.sort(((o1, o2) -> {
            int num = o1.length();
            int num2 = o2.length();
            return num - num2;
        }));
        System.out.println(list);

        list.sort((o1, o2) -> o2.length()-o1.length());
        System.out.println(list);
    }
}
