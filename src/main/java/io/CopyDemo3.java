package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
        /*
        FileInputStream fis = new FileInputStream("image.jpg");
        FileOutputStream fos = new FileOutputStream("image_cp2.jpg");

        byte[] data = new byte[1024 * 10];
        int d ;
        long start = System.currentTimeMillis();
        while ((d = fis.read(data))!=-1){
            fos.write(data,0,d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕！耗时："+(end-start)+"ms");
        */
        FileInputStream fis = new FileInputStream("image.jpg");
        FileOutputStream fos = new FileOutputStream("image_cp3.jpg");
        byte[] data = new byte[1024*10];
        int d;
        long start = System.currentTimeMillis();
        while ((d = fis.read(data))!=-1){
            fos.write(data,0,d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕！耗时："+(end-start)+"ms");
    }
}
