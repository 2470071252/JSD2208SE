package file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入文件名：");
            String accpet = scanner.nextLine();
            File file = new File("./"+accpet);
            if (file.exists()) {
                System.out.println("该文件已存在请重新输入!");
            }else {
                file.createNewFile();
                System.out.println("文件创建成功！");
                break;
            }
        }
    }
}
