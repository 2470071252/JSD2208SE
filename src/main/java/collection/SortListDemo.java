package collection;

import java.util.*;

public class SortListDemo {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new LinkedList<>();
        for ( int i = 10; i > 0; i-- ) {
            list.add(random.nextInt(100)+1);
        }
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);
    }
}
