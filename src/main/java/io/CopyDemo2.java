package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
通过提高每次读写的数据量，减少实际读写的次数可以提高读写效率
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("image.jpg");
        FileOutputStream fos = new FileOutputStream("image_cp2.jpg");

        byte[] data = new byte[1024 * 10];
        int d ;
        long start = System.currentTimeMillis();
        while ((d = fis.read(data))!=-1){
            fos.write(data);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕！耗时："+(end-start)+"ms");

    }
}
