package io;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
从文件中读取文本数据
 */
public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("note.txt");
        // 将文件从数据中读取出来
        FileInputStream fis = new FileInputStream(file);
        long len = file.length(); // 获取文件长度(字节)
        byte[] data = new byte[(int) len];
        fis.read(data);  // 块读操作，将文件所有字节都入到数组中
        String line =new String (data, StandardCharsets.UTF_8);
        System.out.println(line);

        fis.close();




    }
}
