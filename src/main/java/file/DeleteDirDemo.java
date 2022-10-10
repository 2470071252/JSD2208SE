package file;
import java.io.File;

public class DeleteDirDemo {
    public static void main(String[] args) {
        File file = new File("demo");
        if (file.exists()) {
            file.delete();  // file.delete()只能删除空目录
            System.out.println("文件夹已删除");
        }else System.out.println("文件夹不存在");
    }
}
