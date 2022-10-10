package file;

import java.io.File;

/**
 * 筛选项目目录下以"."开头的文件
 */
public class ListFilesDemo2 {
    public static void main(String[] args) {
        // 获取当前目录中名字以"."开头的子项
        File dir = new File(".");
        File[] subs = dir.listFiles(pathname -> {
            String name = pathname.getName();
            return  name.startsWith(".");
        });
        System.out.println(subs.length);
        for ( File sub : subs ) {
            String name = sub.getName();
            System.out.println(name);
        }
    }
}
