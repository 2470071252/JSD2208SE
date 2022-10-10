package io;

import java.io.*;

/**
 * 利用缓冲输入流将src/main/java目录小所有.java文件输入到控制台上
 */
public class Test7 {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/main/java");
        // 获取目录名
        File[] dirFile = file.listFiles();
        // 遍历java目录下的所有.java文件
        for ( File f1 : dirFile ) {
            File[] files= f1.listFiles(f->f.getName().endsWith(".java"));
            // 遍历读取所有.java文件
            for ( File fJava : files ) {
                FileInputStream fis = new FileInputStream(fJava);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader bfr = new BufferedReader(isr);
                String line;
                while ((line=bfr.readLine()) != null) {
                    System.out.println(line);
                }
                bfr.close();
            }
        }

    }
}
