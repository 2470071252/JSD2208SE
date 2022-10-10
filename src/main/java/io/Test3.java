package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
/*
获取./src/main/java/io文件下所有".java"结尾的文件并输出
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/main/java/io");  // 设置目录位置
        // 获取所有以".java"结尾的文件
        File[] files = file.listFiles(f -> f.getName().endsWith(".java"));
        for ( File f : files ) { // 遍历所以以.java结尾的文件
            FileInputStream fis = new FileInputStream(f);  // 创建以".java结尾"的FIS文件对象
            long length = f.length();  // 获取字节大小
            byte[] data = new byte[(int) length];
            fis.read(data);
            String string = new String(data, StandardCharsets.UTF_8);
            System.out.println(string);
            fis.close();
        }
    }
}
