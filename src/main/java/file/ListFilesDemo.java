package file;

import java.io.File;

/**
 * 获取一个目录中的子项
 */
public class ListFilesDemo {
    public static void main(String[] args) {
        // 列出当前项目目录中所有子项
        File file = new File(".");
        if (file.isDirectory()) {
            File[] subs = file.listFiles();
            System.out.println(subs.length);
            for ( File sub : subs ) {
                System.out.println(sub.getName());
            }
        }

    }
}
