package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用有参构造器
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person p = new Person("李四",32);
        System.out.println(p);


        // 加载类对象
        Class<?> cls = Class.forName("reflect.Person");

        /*
        Constructor构造器对象
        该类的每一个实例用于表示一个类中的某个构造器
         */
        // 通过类对象获取无参构造器
        // Constructor<?> constructor = cls.getConstructor();

        // Person(String,int)
        Constructor<?> constructor = cls.getConstructor(String.class,int.class);
        Object wangwu = constructor.newInstance("wangwu", 12);
        System.out.println(wangwu);

    }
}
