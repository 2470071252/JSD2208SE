package reflect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

/**
 * Java反射机制
 * 反射是java的动态机制，可以在程序【运行期间】再确定如：对象实例化，方法调用
 * 属性等操作
 * 反射机制可以大大提高代码的灵活度和可扩展性，但是随之而来的较慢的运行
 * 效率和更多的系统开销，因此不能过度依赖反射机制
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        Class 类
        Class类的实例被成为"类对象"
        JVM在加载一个类的class文件到内部时就会实例化一个Class实例
        与加载的类对应，用这个Class实例记录加载类的相关信息。并且在
        JVM内部每个被加载的类【都有且只有一个】类对象与之对应。

        获取一个类的类对象方式有：
        1. 类名.class
            CLass cls = String.class;
        2. 使用Class.forName(String className)
            参数：类的完全限定名（包名.类）
            Class cls = Class.forName("java.lang.String")
        3. 使用ClassLoader加载
         */
        // 获取String的类对象

        /*
        Class cls = String.class;
        String name = cls.getName(); // 获取类的完全限定名    java.lang.String
        System.out.println(name);
        name = cls.getSimpleName();  // 获取类的简要类名    String
        System.out.println(name);

        *//*
        Method类

         *//*
        Method[] methods = cls.getMethods();
        System.out.println(name+"一共有"+methods.length+"个公开方法");
        for ( Method method: methods ){
            System.out.println(method.getName());
        }

        System.out.println("---------------------------------------------");

        cls = Class.forName("reflect.Person");

        Class<Person> personClass = Person.class;
        name = personClass.getName();
        System.out.println(name);
        name = personClass.getSimpleName();
        System.out.println(name);


        methods = personClass.getMethods();
        System.out.println(name+"一共有"+methods.length+"个公开方法");
        for ( Method method : methods ) {
            System.out.println(method.getName());
        }
        */

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名");
        String className = scanner.nextLine();
        Class cls = Class.forName(className);

        String name = cls.getName();
        Method[] methods = cls.getMethods();
        System.out.println(name);
        for ( Method method : methods ) {
            System.out.println(method.getName());
        }


    }
}
