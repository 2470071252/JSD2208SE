package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(3,4));
        list.add(new Point(13,45));
        list.add(new Point(79,98));
        list.add(new Point(5,6));
        list.add(new Point(34,2));
        System.out.println(list);

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int l1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
                int l2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
                return l1-l2;
            }
        });
        System.out.println(list);

        Collections.sort(list,((o1, o2) -> {
            int l1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
            int l2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
            return l2-l1;
        }));
        System.out.println(list);
    }
}
