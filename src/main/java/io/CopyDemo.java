package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("image_cp.jpg");
        FileInputStream fis = new FileInputStream("image.jpg");
        int d;
        while ((d = fis.read())!=-1){
            fos.write(d);
        }
        System.out.println("复制成功！");
        fis.close();
        fos.close();

    }
}
