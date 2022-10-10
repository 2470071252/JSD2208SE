package file;

import java.io.File;
import java.io.IOException;

/**
 * 在当前项目目录下创建100个文件，名称为test1.txt--test100.txt
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        for ( int i = 100; i > 0; i-- ) {
            File file = new File("./test"+i+".txt");
            if (file.exists()) {
                System.out.println("文件已存在！");
            }else {
                file.createNewFile();
            }
        }
    }
}
