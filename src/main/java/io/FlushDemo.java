package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 缓冲输出流的写出数据时的缓冲区问题
 */

public class FlushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        String line = "爱你孤身走暗巷";
        bos.write(line.getBytes(StandardCharsets.UTF_8));

        bos.flush(); // flush（刷新）

        System.out.println("写出完毕！");
        bos.close();
    }
}
