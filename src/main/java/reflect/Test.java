package reflect;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * 实例化与当前类Test所在同一个包中的每一个类的实例（使用无参构造器）
 */
public class Test {
    public static void main(String[] args) throws URISyntaxException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> cls = Test.class;
        File dir = new File(
                Test.class.getResource(".").toURI()
        );
//        List<String> nameList = new ArrayList<>();

        // 获取类名传入nameList列表
        File[] files = dir.listFiles(f -> f.getName().endsWith(".class"));
        /*
        for ( File file : files ) {
            String[] split = file.getName().split("\\.class");
            for ( String string : split ) {
                nameList.add(string);
            }
        }

        for ( String name : nameList ) {
            Class<?> cls = Class.forName(dir.getName()+"."+name);
            Object obj = cls.newInstance();
            System.out.println(obj);
        }
        */

        /*
        for ( File file : files ) {
            String[] split = file.getName().split("\\.class");
            for ( String name : split ) {
                Class<?> cls = Class.forName(dir.getName()+"."+name);
                Object obj = cls.newInstance();
                System.out.println(obj);
            }
        }
        */
        String packageName = cls.getPackage().getName();
        System.out.println(packageName);

        for ( File file : files ) {
            String fileName = file.getName();
            String className = fileName.substring(0, fileName.indexOf("."));
//            System.out.println(name);
            className = packageName+"."+className;

            Class<?> c = Class.forName(className);
            Object obj = c.newInstance();
            System.out.println(obj);
        }
        System.out.println(dir);

    }

}
