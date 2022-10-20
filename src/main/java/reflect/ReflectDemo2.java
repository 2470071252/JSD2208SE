package reflect;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 使用类对象实例化
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Person p = new Person();
        System.out.println(p);


         /*
            反射机制进行实例化的步骤:
            1:加载要实例化对象的类的类对象
            2:直接通过类对象的方法newInstance()实例化
         */
//        Class cls = Class.forName("reflect.Person");
        /*
            java.util.ArrayList     java.util.HashMap
            reflect.Person          java.util.Date
         */

//        Class<?> cls = Class.forName("reflect.Person");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个类名");
        String className = scanner.nextLine();
        Class<?> cls = Class.forName(className);
        // newInstance()会调用类对象所表示的类的【公开的无参构造器】实例化
        Object obj = cls.newInstance(); // new Person();
        System.out.println(obj);
    }
}
