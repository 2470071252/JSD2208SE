package file;

import java.io.File;

public class DeletePractice {
    public static void main(String[] args) {
        File file = new File("test.txt");
        if (file.exists()) {
            file.delete();
            System.out.println("该文件已删除");
        }else System.out.println("该文件不存在");
    }
}
