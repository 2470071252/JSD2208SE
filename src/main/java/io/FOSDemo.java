package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Java IO
 * IO：Input和Output
 * input（读）、output（写）
 *
 * InputStream和OutputStream类
 * 他们是所有字节流输入和输出的超类，并且他们本身是抽象类
 * java.io.InputStream上定义了读取字节的相关方法，所有子类都需实现
 * java.io.OutputStream上定义了写出字节的相关方法，所有子类都需实现
 * 文件流继承了InputStream和OutputStream
 *
 *
 *
 * 文件流
 * java.io.FileInputStream  文件输入流
 * java.io.FileOutputStream 文件输出流
 *
 *FileInputStream(String path, boolean append)
 *FileOutputStream(File file, boolean append)
 * 上述两种构造器可以提供追加模式，如果第二个参数为true则为追加模式
 *
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        /*
        文件输出流常见的两个构造器
        FileOutputStream(String path)
        FileOutputStream(File file)
         */
        // 向文件中写出一个字节（8位2进制）
        //File file = new File("fos.dat");\
        // 如果文件不存在会自动创建文件
        FileOutputStream fos = new FileOutputStream("fos.dat");
        /*
        void write(int d)
        写出一个字节，写出的是给定的int值对应的2进制"低八位"
         */
        fos.write(1);
        fos.write(13);
        fos.close();

    }
}
