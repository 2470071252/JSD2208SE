package io;

import java.io.*;

/**
 * java将流分为节点流和处理流
 * 节点流：也称为低级流，是实际连接程序与另一端的"管道"，负责实际读写
 * 处理六：也称为高级流，不能独立存在。
 *
 */
public class CopyDemo4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("image_cp4.jpg");
        FileInputStream fis = new FileInputStream("image.jpg");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        BufferedInputStream bis = new BufferedInputStream(fis);
        /*
        缓冲流默认缓冲区大小为8kb
        可以通过重载的构造器，在第二个参数通过整数来指定需要的缓冲区大小
        BufferedOutputStream bos = new BufferedOutputStream(fos,1024*10);
         */

        int d;
        long start = System.currentTimeMillis();
        /*
        缓冲流内部有一个默认为8k的字节数组，实际上当我们第一次通过
        缓冲流读取字节数时，缓冲流一定是一次性读取8k进入缓冲区
        因为，无论我们如何读取，缓冲输入流一定是转成了块状来保证读取效率
        缓冲输出流也是如此
         */
        while ((d = bis.read())!=-1){
            bos.write(d);
        }
        long end  = System.currentTimeMillis();
        System.out.println(end-start+"ms");
    }
}
