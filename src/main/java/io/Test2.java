package io;

import com.sun.istack.internal.NotNull;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

/*
使用文件流实现简易记事本工具
程序启动后将用户在控制台输入的每一行字符串都写入到note.txt文件中
当用户在控制台单独输入"exit"时，程序退出
（不用考虑换行问题）
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        // 文件开启了追加模式
        FileOutputStream fos = new FileOutputStream("note.txt",true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("###简单记事本###");
        while (true){
            @NotNull
            String line = scanner.nextLine();
            if ("exit".equals(line.toLowerCase())) {
                System.out.println("欢迎再次使用!");
                break;
            }else {
                byte[] data = line.getBytes(StandardCharsets.UTF_8);
                byte[] n = "\n".getBytes(StandardCharsets.UTF_8);
                fos.write(data);
                fos.write(n);
            }
        }
        System.out.println("再见!");
        fos.close();
    }


}
