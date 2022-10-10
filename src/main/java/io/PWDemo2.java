package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 自行完成流连接
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        // 文件输出流(字节流，低级流)：负责将字节写入到文件中
        FileOutputStream fos = new FileOutputStream("pw.txt",true);  // 追加模式
        // 转换输出流（字符流，高级流）：1.负责衔接字节与字符流  2.负责将写出的字符转换为字节
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8); // 字符编码修改
        // 缓冲字符输出流(字符流，高级流)：负责块写文本数据加速
        BufferedWriter bw = new BufferedWriter(osw);
        // PrintWriter(字符流，高级流)：1.按行写出字符串  2. 自动刷新
        /*
        当使用PrintWriter的构造器：
        PrintWriter(OutputStream out, boolean autoFlush)
        PrintWriter(Writer w, boolean autoFlush)
        并且第二个参数为true时，则打开了自动刷新功能，这样一来每当
        我们使用println方法写出一行字符串时就会自动flush一次
         */
        PrintWriter pw = new PrintWriter(bw,true); // 自动刷新，可以自动调用flush()
        /*
         * 简易记事本，exit时程序退出
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文字：");
        while (true){
            String accept =scanner.nextLine();
            if (accept.toLowerCase().equals("exit")){
                break;
            }
            pw.println(accept);
            // pw.flush();
            // 可以在PrintWriter中设置自动刷新，但是在autoFlush中print不会调用flush()
        }
        pw.close();
        System.out.println("再见!");


    }
}
