package file;

import java.io.File;
import java.io.FileFilter;


/**
 * 获取当前项目目录下名字中含有a的所有子项
 */
public class Test3 {
    public static void main(String[] args) {
        File file = new File(".");
        if (file.isDirectory()) {
            File[] subs = file.listFiles(pathname -> pathname.getName().contains("a"));
            System.out.println(subs.length);
            for ( File sub : subs ) {
                System.out.println(sub.getName());
            }
        }
        /*
        if (file.isDirectory()) {
            File[] subs = file.listFiles(pathname -> {
                String name = pathname.getName();
                return name.matches("/a/");
            });
            for ( File sub : subs ) {
                System.out.println(sub.getName());
            }
        }
        */
    }
}
