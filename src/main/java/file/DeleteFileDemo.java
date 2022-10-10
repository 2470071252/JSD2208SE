package file;

import java.io.File;

/**
 * 将当前项目目录下的testx.txt删除
 */
public class DeleteFileDemo {
    public static void main(String[] args) {
        // 将当前项目testx.txt文件删除
        // 在相对路径最开始的"./"可以忽略不写，默认就是从"./"开始
        for ( int i = 100; i > 0; i-- ) {
            File file = new File("test"+i+".txt");
            if (file.exists()) {
                file.delete();  // 将File表示的文件删除
                System.out.println("该文件已删除");
            }else System.out.println("该文件不存在");
        }
    }
}
