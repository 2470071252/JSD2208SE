package io;

import java.io.*;

/**
 * 缓冲字符输入流java.io.BufferedReader
 * 缓冲字符输入流内部维护一个8k的char数组，块读文本数据加速
 * 并且直接提供了读取一行字符串的方法readLine()
 */

public class BRDemo {
    // 将当前源代码输出到控制台上
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./src/main/java/io/BRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bfr = new BufferedReader(isr);
//        String line = bfr.readLine();
        /*
        读取一行字符串，返回字符串
        当单独读取了换行符(空行)，则返回值为空字符串
        如果读取完，则会返回null
         */
        String line;
        while ((line = bfr.readLine()) != null) {
            System.out.println(line);
        }
        bfr.close();
    }
}
