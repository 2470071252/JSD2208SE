package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("image.jpg");
        FileOutputStream fos = new FileOutputStream("image_cp.jpg");
        int d;
        long start = System.currentTimeMillis();
        while ((d = fis.read())!=-1){
            fos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕！耗时："+(end-start)+"ms");
        fis.close();
        fos.close();
    }
}
