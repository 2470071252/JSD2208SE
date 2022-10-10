package file;

import java.io.File;

public class MkDirDemo {
    public static void main(String[] args) {
        // 在当前目录下新建一个目录demo
        File demo = new File("demo/a/b/c/d");
        if (demo.exists()) {
            System.out.println("文件夹已存在");
        }else{
            // 创建多个目录
            demo.mkdirs();  // demo.mkdir()创建单个目录
            System.out.println("目录已创建");
        }

    }
}
