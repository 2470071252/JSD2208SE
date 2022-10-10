package io;

import java.io.*;

/**
 * 将当前项目目录下的所有obj文件进行反序列化，并输出User对象
 */
public class Test6 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("./");
        // 获得所有.obj对象
        File[] files = file.listFiles(f -> f.getName().endsWith(".obj"));
        for ( File f : files ) {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            if (o instanceof User) {
                System.out.println(o);
            }
            ois.close();
        }
    }
}
