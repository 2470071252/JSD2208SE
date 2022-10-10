package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaPractice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        List<String> list = new LinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        System.out.println(list);

        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };

        Comparator<String> c1 = ((o1, o2) -> o1.length()-o2.length());
    }
}
